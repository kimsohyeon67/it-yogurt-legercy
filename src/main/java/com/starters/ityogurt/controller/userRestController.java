package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class userRestController {

    @Autowired
    @Qualifier("userservice")
    UserService userService;

    // 로그인
    @PostMapping("/user")
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
