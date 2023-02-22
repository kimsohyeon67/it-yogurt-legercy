package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.error.ApiException;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userservice")
    UserService userService;

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

    @GetMapping("/user/check/{knowSeq}")
    public ModelAndView QuizLoginCheck(@PathVariable(value = "knowSeq") int knowSeq) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("knowSeq", knowSeq);
        mv.setViewName("user/check");
        return mv;
    }

    // 이메일 인증 페이지
    @GetMapping("/user/verify/{user_seq}")
    public ModelAndView Verify(@PathVariable("user_seq") int userSeq) throws ApiException {
        ModelAndView mv = new ModelAndView();
        int result = userService.setIsPassByUserSeq(userSeq);
        String str = result == 1 ? "이메일 인증이 완료되었습니다." : "이메일 인증에 실패했습니다. 정보를 다시 확인해주세요";

        mv.addObject("result", str);
        mv.setViewName("user/verify");
        return mv;
    }
    
    @GetMapping("/myPage/{user_seq}")
    public String myPage(@PathVariable("user_seq") String user_seq) {
//    	ModelAndView mv = new ModelAndView();
//    	System.out.println(user_seq);
//    	mv.setViewName("user/myPage");
        return "user/myPage";
    }
}
