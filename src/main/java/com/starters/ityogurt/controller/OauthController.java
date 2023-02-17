package com.starters.ityogurt.controller;

import com.starters.ityogurt.oauth.OauthService;
import com.starters.ityogurt.oauth.SocialLoginType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OauthController {

    @Autowired
    OauthService oauthService;

    @GetMapping("/auth/{socialLoginType}")
    public void socialLoginType(
        @PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
        HttpServletResponse response) {
        oauthService.request(socialLoginType, response);
    }

    @GetMapping("/auth/{socialLoginType}/callback")
    public String callback(@PathVariable(name = "socialLoginType") SocialLoginType socialLoginType,
        @RequestParam(name = "code") String code, HttpServletRequest request) {

        String email = oauthService.requestAccessToken(socialLoginType, code);

        HttpSession session = request.getSession();

        session.setAttribute("email", email);
        session.setAttribute("isSNS", "true");

        return "redirect:/user/1";
    }

}

