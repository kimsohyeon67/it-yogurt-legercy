package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.LearnRecordQuizDTO;
import com.starters.ityogurt.service.LearnRecordQuizService;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/quiz/wrong/{user_seq}")
    @ResponseBody
    public ModelAndView setviewWrong(
        @PathVariable("user_seq") String userSeq) {

        ModelAndView mv = new ModelAndView();
//        int start = current * limit;
//        int end = current * limit + limit;
//
//        // List<LearnRecordQuizDTO> list = service.getWrongAnswerByUser(userSeq, String.valueOf(start), String.valueOf(end));
//
        mv.setViewName("quiz/wrong");
//        mv.addObject("quizList",list);
//        mv.addObject("start",start);
//        mv.addObject("end",end);
        return mv;
    }

    // 틀린 문제 개수 가져오기. limit 기본값 : 5
    @GetMapping("/quiz/wrong/{user_seq}/list")
    @ResponseBody
    public JSONObject getWrongQuiz(
        @PathVariable("user_seq") String userSeq, @RequestParam(defaultValue ="1")int current,
        @RequestParam(defaultValue ="5") int limit) {

        int start = current * limit;
        int end = current * limit + limit;

        List<LearnRecordQuizDTO> list = service.getWrongAnswerByUser(userSeq, String.valueOf(start), String.valueOf(end));

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("quizList", list);
        jsonObj.put("start", start);
        jsonObj.put("end", end);

        return jsonObj;
    }


}
