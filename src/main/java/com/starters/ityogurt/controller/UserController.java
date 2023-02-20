package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userservice")
    UserService userService;

    //region === 페이지 ===

    // 로그인 페이지
    @GetMapping("/user")
    public String getLoginPage() {
        return "user/login";
    }

    // 회원가입 페이지
    @GetMapping("/user/1")
    public String getSignUpPage(HttpSession session) {

        System.out.println(session.getAttribute("email"));
        System.out.println(session.getAttribute("isSNS"));
        return "user/signUp";
    }

    //endregion

    //region === 기능 ===

    // 비밀번호 암호화
    String ConvertPassword(String pw) throws Exception {
        Encrypt crypto = new Encrypt();
        pw = crypto.encryptAES256(pw);
        return pw;
    }
    //endregion
}
