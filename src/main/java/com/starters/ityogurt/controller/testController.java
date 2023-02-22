package com.starters.ityogurt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/index1")
    public String main1() {
        return "index1";
    }

}
