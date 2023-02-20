package com.starters.ityogurt.controller;

import java.util.*;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.*;
import com.starters.ityogurt.serviceimpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    CategoryService categoryService;

    @Value("${live.ip}")
    private String liveIp;

    // private final EmailService emailService;

    //이메일 전송 API
/*     @RequestMapping("/aws/email")
    @Scheduled(cron = "0 30 7 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
         List<Map<String, String>> subEmailMap = emailService.getEmailAndSub();
         int categorySeq = emailService.getSendDetail().getCategorySeq();
         int knowledgeSeq = emailService.getSendDetail().getKnowSeq();

        // List<String> javaReceivers = emailService.getSendEmailsSubJava();       // 자바 카테고리를 구독한 사람
        String subject = "오늘은 " + emailService.getSendDetail().getTitle() + "에 대해 알아보자!";     // 제목
        String content = headerText() + emailService.getSendDetail().getContent() + buttonText(knowledgeSeq) + footerText();      // 본문

         System.out.println(categorySeq);
         System.out.println(knowledgeSeq);
         System.out.println(subEmailMap);
         System.out.println(subject);
         System.out.println(content);

        System.out.println("테스트!");
        // emailService.updateSendDate(categorySeq);
        // emailService.send(subject, content, javaReceivers);

        return "true";
    }*/

    @RequestMapping("/aws/email")
    @Scheduled(cron = "0 30 7 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
        List<Map<String, Object>> subEmailMap = emailService.getEmailAndSub();          // 유저의 이메일과 유저가 선택한 소분류를 map에 담은 것을 반환한다.
        int count = categoryService.countAllSub();                                      // 총 소분류의 갯수이다.
        List<Map<String, Object>> sendDetailMap = emailService.getSendDetail(count);    // 소분류에서 어떤 상세분류를 보낼 것인지를 map에 담아 반환한다.
        System.out.println(subEmailMap);
        System.out.println(count);
        System.out.println(sendDetailMap);
        System.out.println(sendDetailMap.get(0).get("category_seq"));
        System.out.println(sendDetailMap.get(0).get("category_seq").getClass().getName());
        System.out.println(sendDetailMap.get(0).get("sub"));
        System.out.println(sendDetailMap.get(0).get("sub").getClass().getName());

        int categorySeq = (Integer) sendDetailMap.get(0).get("category_seq");

        sendDetailMap.get(0).get("sub");
        System.out.println(sendDetailMap.get(0).get("sub"));
        if (sendDetailMap.get(0).get("sub").equals("java")) {
            String content = knowledgeService.getKnowledgeByCategorySeq(categorySeq).getContent();
            String title = knowledgeService.getKnowledgeByCategorySeq(categorySeq).getTitle();
            System.out.println(content);
            System.out.println(title);
        }

        System.out.println("테스트!");

        // emailService.updateSendDate(categorySeq);
        // emailService.send(subject, content, javaReceivers);      // 제목, 컨텐츠, 받는 사람이 들어간다.
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

    public String buttonText(@RequestParam(value = "knowseq")int knowseq) {
        String buttonText = "<br><a href='http://"+ liveIp + ":8818/quiz?knowSeq="+knowseq +"'><button class=\"btn btn-primary\">문제 풀기!</button></a>";
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
