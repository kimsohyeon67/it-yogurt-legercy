package com.starters.ityogurt.controller;

import java.util.*;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.EmailService;
import com.starters.ityogurt.service.KnowledgeService;
import com.starters.ityogurt.service.QuizService;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.serviceimpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {

    @Autowired
    QuizService quizService;

    @Autowired
    KnowledgeService knowledgeService;

    @Autowired
    EmailService emailService;

       // private final EmailService emailService;

    //이메일 전송 API
    @RequestMapping("/aws/email")
    @Scheduled(cron = "0 30 7 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
        List<String> receivers = emailService.getAllEmails();       // 받는 사람
        String subject = "오늘은 " + knowledgeService.title(4) + "에 대해 알아보자!";     // 제목
        String content = headerText() + knowledgeService.contents(4) + buttonText(4) + footerText();      // 본문

        System.out.println("테스트!");

        emailService.send(subject, content, receivers);

        return "true";
    }

    // 나중에 탄력적 ip로 img 주소 변경
    public String headerText() {
        String headerText = "<div style=\"text-align : center;\">\n" +
                "  <h1>IT-Yogurt!</h1>\n" +
                "  <img style=\"width:300px; height: 300px; \"  src=\"/static/image/yogurt.jpg\">\n" +
                "  </div>" +
                "  <br><br><hr><br><br>";
        return headerText;
    }

    public String buttonText(@RequestParam(value = "knowseq")int knowseq) {
        String buttonText = "<br><a href='http://localhost:8818/quiz?knowSeq="+knowseq +"'><button class=\"btn btn-primary\">문제 풀기!</button></a>";
        return buttonText;
    }
    public String footerText() {
        String footerText = "<div class=\"footer\" style=\"text-align : center; background-color: #F9F2ED\">\n" +
                "  <div class=\"info\" ><br>\n" +
                "    ItYogurt / 대표: 김민지<br>\n" +
                "    서울특별시 용산구 용산동2가 1 - 34<br><br><br><br>\n" +
                "  </div>\n" +
                "</div>";
        return footerText;
    }

}
