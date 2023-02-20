package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.LearnRecordQuizDTO;
import com.starters.ityogurt.service.LearnRecordQuizService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LearnRecordQuizController {

    @Autowired
    LearnRecordQuizDTO dao;

    @Autowired
    @Qualifier("recodequizservice")
    LearnRecordQuizService service;

    @GetMapping("/quiz/wrong/{user_seq}") //매일지식 폼 확인
    public ModelAndView getWrongQuiz(
        String userSeq) {
        ModelAndView mv = new ModelAndView();
        List<LearnRecordQuizDTO> list = service.getWrongAnswerByUser(userSeq);

        mv.addObject("quizList", list);
        mv.setViewName("/quiz/wrong");
        return mv;
    }


}
