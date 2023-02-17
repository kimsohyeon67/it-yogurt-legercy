package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class userRestController {

    @Autowired
    @Qualifier("userservice")
    UserService userService;

    // 로그인
    @PostMapping("/user")
    @ResponseBody // RESPONSEENTITY
    public String Login(UserDTO dto, HttpServletRequest request) {
        String error = "";
        try {
            UserDTO result = userService.getUserByUserEmail(dto.getEmail());
            if (result == null) {
//                mv.setViewName("/user");
//                mv.addObject("error", "가입되지 않은 사용자입니다.");
                error = "가입되지 않은 사용자입니다.";
            } else if (result.getPassword() == null || result.getPassword() == "") {
//                mv.setViewName("/user");
//                mv.addObject("error", "간편 로그인 사용자입니다. 간편 로그인을 해주세요.");
                error = "간편 로그인 사용자입니다. 간편 로그인을 해주세요.";
            } else {
                String pw = ConvertPassword(dto.getPassword());
                if (pw.equals(result.getPassword())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user_seq", result.getUserSeq());
//                    mv.setViewName("/");
                } else {
//                    mv.setViewName("/user");
//                    mv.addObject("error", "회원정보를 다시 확인해주세요.");
                    error = "회원정보를 다시 확인해주세요.";
                }
            }

        } catch (Exception e) {
            // http status를 모우 200으로 내리고 바디에 코드를 넣어서, 1이면 정상 5면 어쩌고 이렇게 ...
            // 2. 아니면 httpstatus에 넣어서 넣는 경ㅇ.
            // api를 어떻게 구현하느냐에 따라 1과 2가 다르다. ->명세서에 쓰자
            log.info("internal server error",e);
        }
        return error;
    }

    // 비밀번호 암호화
    String ConvertPassword(String pw) throws Exception {
        Encrypt crypto = new Encrypt();
        pw = crypto.encryptAES256(pw);
        return pw;
    }
    //endregion
}
