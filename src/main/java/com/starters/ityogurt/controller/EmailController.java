package com.starters.ityogurt.controller;

import java.util.*;

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
        //받는이
        List<String> receivers = new ArrayList<>();
        receivers.add("mjkim856@gmail.com");
        //제목
        String subject = "자바의 스케줄러에 대해 알아보자!";
        //본문
        String content = "Java에서 연산자는 값을 변환하거나 표현식의 결과를 계산하는 데 사용됩니다.<br>\n" +
                "<br><b>1. 산술 연산자</b>\n" +
                "<br>산술 연산자는 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나머지 연산(%) 등의 산술 연산을 수행합니다.\n" +
                "<br>예시:\n" +
                "<br>int x = 10;\n" +
                "<br>int y = 20;\n" +
                "<br>int result = x + y;   // result = 30 <br>\n" +
                "<br><b>2. 비교 연산자</b>\n" +
                "<br>비교 연산자는 두 값을 비교하여 결과를 true 또는 false로 반환합니다.\n" +
                "<br>같음(==)\n" +
                "<br>같지 않음(!=)\n" +
                "<br>크다(>)\n" +
                "<br>작다(<)\n" +
                "<br>크거나 같다(>=)\n" +
                "<br>작거나 같다(<=)\n" +
                "<br>예시:\n" +
                "<br>int x = 10;\n" +
                "<br>int y = 20;\n" +
                "<br>boolean result = x < y;   // result = true <br>\n" +
                "<br><b>3. 논리 연산자</b>\n" +
                "<br>논리 연산자는 true 또는 false의 값을 가진 논리 표현식을 연산합니다.\n" +
                "<br>AND (&&)\n" +
                "<br>OR (||)\n" +
                "<br>NOT (!)\n" +
                "<br>예시:\n" +
                "<br>boolean a = true;\n" +
                "<br>boolean b = false;\n" +
                "<br>boolean result = a && b;   // result = false <br>" +
                "<button type=\"button\" onclick=\"location.href='http://localhost:8818/detail?knowSeq=1' \">회원가입</button>" +
                "<a href='https://github.com/javaee/javamail'>Javamail Package</a>" +
                "<a href='http://localhost:8818/detail?knowSeq=1'><button class=\"btn btn-primary\">Javamail Package</button></a>";

        System.out.println("테스트!");

        emailService.send(subject, content, receivers);

        return "true";
    }



//    private final EmailService emailService;

//    //이메일 전송 API
//    @RequestMapping("/aws/email")
//    public String sendEmail() throws Exception {
//        //받는이
//        List<String> receivers = new ArrayList<>();
//        receivers.add("mjkim856@gmail.com");
//        receivers.add("ityogurt213@gmail.com");
//        //제목
//        String subject = "SES Test";
//        //본문
//        String content = "이메일 전송 테스트";
//
//        sendEmailServiceImpl.send(subject, content, receivers);
//
//        return "true";
//    }

/*
    //이메일 전송 API
    @RequestMapping("/aws/email")
    public String sendEmail() throws Exception {
        //받는이
        // 안에 모든 유저의 이메일이 들어 있다.
        List<String> receivers = emailService.getAllEmails();

        // 제목
        // 만약 100명의 사람에게 보낸다고 할 떄, 뭐가 가장 효율적인 방법일까?
        // 일단은 소수 유저에게만 보낸다고 가정하자.
//      String subject = knowledgeService.title(1);
        String subject = knowledgeService.title(7);
        //본문
        String content = knowledgeService.contents(7);

        List<HashMap<String, String>> list = knowledgeService.knowledgeByUserCategory();
        for(HashMap map:list) {
            Set<String> keys = map.keySet();
            for(String s:keys) {
                System.out.println(s + " : " + map.get(s));
            }
        }

        emailService.send(subject, content, receivers);

        return "true";
    }
*/
}
