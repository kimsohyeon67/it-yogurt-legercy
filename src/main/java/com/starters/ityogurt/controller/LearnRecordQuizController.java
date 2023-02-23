package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.LearnRecordDTO;
import com.starters.ityogurt.dto.LearnRecordQuizDTO;
import com.starters.ityogurt.error.ApiException;
import com.starters.ityogurt.error.ErrorCode;
import com.starters.ityogurt.service.LearnRecordQuizService;

import com.starters.ityogurt.service.LearnRecordService;
import com.starters.ityogurt.util.Criteria;
import com.starters.ityogurt.util.Paging;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LearnRecordQuizController {

    @Autowired
    LearnRecordQuizDTO dao;

    @Autowired
    @Qualifier("recodequizservice")
    LearnRecordQuizService service;

    @Autowired
    LearnRecordService recodeservice;

    // 틀린 문제 개수 가져오기. limit 기본값 : 5
    @GetMapping("/quiz/wrong/{user_seq}/list")
    @ResponseBody
    public ModelMap getWrongQuiz(Criteria cri,
        @PathVariable("user_seq") int userSeq, @RequestParam(defaultValue = "5") String perPageNum) {
        ModelMap m = new ModelMap();

        Paging paging = new Paging();
        cri.setPerPageNum(Integer.parseInt(perPageNum));
        paging.setCri(cri);

        int totalBoardCnt = service.getWrongAnswerCountByUser(userSeq);
        int maxPage = (int) ((double) totalBoardCnt / cri.getPerPageNum() + 0.9);
        List<LearnRecordQuizDTO> list = service.getWrongAnswerByUser(userSeq, cri.getPageStart(),
            cri.getPerPageNum());
        paging.setTotalCount(totalBoardCnt);
        m.addAttribute("maxPage", maxPage);
        m.addAttribute("paging", paging);
        m.addAttribute("quizList", list);

        return m;
    }

    //오답문제 정보 갱신 시
    @PutMapping("/quiz/wrong/answer/1")
    @ResponseBody
    public void updateWrongQuiz(@RequestBody LearnRecordDTO data) {
        recodeservice.updateLearnData(Integer.parseInt(data.getUserChoice()),data.getIsRight(),data.getUserSeq(), data.getQuizSeq());
    }
}
