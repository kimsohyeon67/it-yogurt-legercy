
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
    private KnowledgeDTO knowledgeByCategorySeq;

    // private final EmailService emailService;
    @RequestMapping("/aws/email")
    @Scheduled(cron = "0 46 1 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
        // 유저의 이메일과 유저가 선택한 소분류를 map에 담은 것을 반환한다.
        List<Map<String, Object>> subEmailMap = emailService.getEmailAndSub();

        // 총 소분류의 갯수이다.
        int count = categoryService.countAllSub();

        // 소분류에서 어떤 상세분류를 보낼 것인지를 map에 담아 반환한다.
        // 가장 오래 전에 보냈으면서 가장 작은 번호 순이다.
        List<Map<String, Object>> sendDetailMap = emailService.getSendDetail(count);

        // User의 이메일과 User가 선택한 소분류가 들어갈 map이다.
        Map<String, String> userMap = new HashMap<String, String>();

        // category의 소분류와 상세번호가 들어갈 map이다.
        Map<String, Integer> categoryMap = new HashMap<String, Integer>();

        // 보내질 카테고리 번호 List이다.
        List<Object> updateCategorySeqList = new ArrayList<Object>();

        // String에는 소분류가, Object에는 해당 소분류를 선택한 사람의 List가 들어가게 될 Map이다.
        Map<String, Object> subEmailList = new HashMap<String, Object>();

        // 1. categoryMap {mariadb=19, java=13}
        for(Map<String, Object> data : sendDetailMap){
            categoryMap.put((String) data.get("sub"), (Integer) data.get("category_seq"));
        }

        // 2. userMap {ityogurt213@gmail.com=mariadb, mjkim856@gmail.com=java, akdrh554@gmail.com=java}
        for(Map<String, Object> data : subEmailMap){
            userMap.put((String) data.get("email"), (String) data.get("sub"));
        }

        // categoryMap의 key(소분류)와 value(발송할 카테고리 번호)를 foreach문을 사용해 값을 꺼낸다.
        // userMap의 userKey(이메일)과 userValue(소분류)를 내부에서 foreach문을 사용해서 값을 꺼낸다.
        // 만약 userMap의 value와 categoryMap의 key가 같다면, emailCollectionList에 userKey를 add한다.
        categoryMap.forEach((key, value) -> {
            // 소분류를 선택한 User들의 email을 담을 List이다.
            // subEmailList의 value값이 된다.
            List emailCollectionList = new ArrayList<Object>();

            userMap.forEach((userKey, userValue) -> {
                if(key.equals(userValue)) {
                    emailCollectionList.add(userKey);
                }
            });
            // {mariadb=[ityogurt213@gmail.com], java=[mjkim856@gmail.com, akdrh554@gmail.com]}
            subEmailList.put(key, emailCollectionList);
        });

        System.out.println("userMap : " + userMap);
        System.out.println("categoryMap : " + categoryMap);

        categoryMap.forEach((key, value) -> {
            emailService.updateSendDate(value);
            KnowledgeDTO knowledgeDTO = knowledgeService.getKnowledgeByCategorySeq((Integer) value);
            emailService.send(knowledgeDTO.getTitle(),
                    headerText() + knowledgeDTO.getContent() + buttonText(knowledgeDTO.getKnowSeq()) + footerText(),
                    (List<String>) subEmailList.get(key));
        });

        KnowledgeDTO knowledgeDTO = knowledgeService.getKnowledgeByCategorySeq(19);
        System.out.println(knowledgeDTO.getKnowSeq());
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

    public String buttonText(@RequestParam(value = "knowSeq")int knowSeq) {
        String buttonText = "<div style=\"text-align: center;\"><br>\n" +
                "       <a href='http://localhost:8818/user/check/"+knowSeq+"'>\n" +
                "               <button class=\"btn\" style=\"width: 200px; background-color: #86b7fe; padding: 15px 30px;\n" +
                "                border-radius: 5px; color:white; font-size: 18px; font-weight: bold; cursor: pointer;\" >문제 풀기!</button>\n" +
                "       </a><br>\n" +
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


