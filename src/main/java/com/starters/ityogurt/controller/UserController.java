package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
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
    public String getSignUpPage() {
        return "user/signUp";
    }

    //endregion

    //region === 기능 ===

    // 로그인
    @PostMapping("/user")
    public ModelAndView Login(UserDTO dto) {
        ModelAndView mv = new ModelAndView();
        int result = userService.insertUser(dto);
        mv.addObject(dto);
        mv.setViewName("userInfo");
        return mv;
    }

    // 회원가입
    @PostMapping("/user/1")
    public ModelAndView SignUp(UserDTO userDTO) throws Exception {
        ModelAndView mv = new ModelAndView();

        Encrypt crypto = new Encrypt();
        userDTO.setPassword(crypto.encryptAES256(userDTO.getPassword()));
        int result = userService.insertUser(userDTO);
        mv.setViewName("login");
        return mv;
    }
    //endregion
}
