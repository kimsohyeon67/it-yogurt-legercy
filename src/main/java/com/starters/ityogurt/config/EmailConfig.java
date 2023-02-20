/*
package com.starters.ityogurt.config;

import java.util.*;

import com.starters.ityogurt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Configuration
public class EmailConfig {

    @Autowired
    QuizService quizService;

    @Autowired
    KnowledgeService knowledgeService;

    @Autowired
    EmailService emailService;

    @Autowired
    CategoryService categoryService;

    @Value("${live.ip}")
    private String liveIp;

    // private final EmailService emailService;

    //이메일 전송 API
    // @RequestMapping("/aws/email")
    @Scheduled(cron = "0 29 20 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
        int categorySeq = emailService.getSendDetail().getCategorySeq();
        int knowledgeSeq = emailService.getSendDetail().getKnowSeq();

        List<String> javaReceivers = emailService.getSendEmailsSubJava();       // 자바 카테고리를 구독한 사람
        String subject = "오늘은 " + emailService.getSendDetail().getTitle() + "에 대해 알아보자!";     // 제목
        String content = headerText() + emailService.getSendDetail().getContent() + buttonText(knowledgeSeq) + footerText();      // 본문

        System.out.println("테스트!");
        emailService.updateSendDate(categorySeq);
        emailService.send(subject, content, javaReceivers);

        return "true";
    }

    // 나중에 탄력적 ip로 img 주소 변경
    public String headerText() {
        String headerText = "<div style=\"text-align : center;\">\n" +
                "  <h1>IT-Yogurt!</h1>\n" +
                // "  <img style=\"width:300px; height: 300px; \"  src=\"/static/image/yogurt.jpg\">\n" +
                "  </div>" +
                "  <br><br><hr><br><br>";
        return headerText;
    }

    public String buttonText(@RequestParam(value = "knowSeq")int knowSeq) {
        String buttonText = "<div style=\"text-align: center;\"><br>\n" +
                "    <a href='http://localhost:8818/user/check/+"+knowSeq +"+>\n" +
                "        <button class=\"btn\" style=\"width: 200px; background-color: #86b7fe; padding: 15px 30px;\n" +
                "                border-radius: 5px; color:white; font-size: 20px; font-weight: bold; cursor: pointer;\" >문제 풀기!</button>\n" +
                "    </a><br>\n" +
                "<br><a href='http://\"+ liveIp + \":8818/quiz?knowSeq=\"+knowSeq +\"'><button class=\\\"btn btn-primary\\\">문제 풀기!</button></a>" +
                "</div>";
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
*/
