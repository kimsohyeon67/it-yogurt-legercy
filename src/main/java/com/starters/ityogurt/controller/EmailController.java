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
    @RequestMapping("/aws/email")
    @Scheduled(cron = "0 30 7 * * ?", zone = "Asia/Seoul")
    public String sendEmail() throws Exception {
        List<Map<String, Object>> subEmailMap = emailService.getEmailAndSub();          // 유저의 이메일과 유저가 선택한 소분류를 map에 담은 것을 반환한다.
        int count = categoryService.countAllSub();                                      // 총 소분류의 갯수이다.
        List<Map<String, Object>> sendDetailMap = emailService.getSendDetail(count);    // 소분류에서 어떤 상세분류를 보낼 것인지를 map에 담아 반환한다.
        Map<String, Object> userMap = new HashMap<String, Object>();
        Map<String, Object> categoryMap = new HashMap<String, Object>();
        List<Object> updateCategorySeqList = new ArrayList<Object>();

        Map<String, Object> map_01 = new HashMap<String, Object>();

        // int categorySeq = (Integer) sendDetailMap.get(0).get("category_seq");
        System.out.println(subEmailMap);
        System.out.println(sendDetailMap);

        // 1. {ityogurt213@gmail.com=mariadb, mjkim856@gmail.com=java, akdrh554@gmail.com=java}
        for(Map<String, Object> data2 : sendDetailMap){
            categoryMap.put((String) data2.get("sub"), data2.get("category_seq"));
        }

        // 2. {mariadb=19, java=13}
        for(Map<String, Object> map : subEmailMap){
            userMap.put((String) map.get("email"), map.get("sub"));
        }

        categoryMap.forEach((key, value) -> {
            List emailCollectionList = new ArrayList<Object>();
            // System.out.println(key + " : " + value);

            userMap.forEach((userKey, userValue) -> {
                // System.out.println(userKey + " : " + userValue);
                if(key.equals(userValue)) {
                    emailCollectionList.add(userKey);
                }
            });
            map_01.put(key, emailCollectionList);
        });

        System.out.println(map_01);
        System.out.println("userMap : " + userMap);
        System.out.println("categoryMap : " + categoryMap);

        //map에 키값과 같은 제네릭을 선언한 iterator에 map 키값들을 넣는다.
        Iterator<String> it = categoryMap.keySet().iterator();

        //키값이 존재할동안 반복
        while(it.hasNext()) {
            String key = it.next();
            System.out.println(" =================== key -> " + key);
            System.out.println(" =================== value ->" + categoryMap.get(key));
            updateCategorySeqList.add(categoryMap.get(key));
        }

        System.out.println(updateCategorySeqList);

        emailService.updateSendDate(updateCategorySeqList);
//        emailService.send(subject, content, javaReceivers);      // 제목, 컨텐츠, 받는 사람이 들어간다.
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
