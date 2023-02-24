package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.LearnRecordDTO;
import com.starters.ityogurt.dto.LearnRecordQuizDTO;
import com.starters.ityogurt.service.LearnRecordQuizService;
import com.starters.ityogurt.service.LearnRecordService;
import com.starters.ityogurt.util.Criteria;
import com.starters.ityogurt.util.Paging;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String getWrongQuiz(){
        return "/user/myPage";
    }

    @GetMapping("/mypage/wrong/{user_seq}")
    public String moveWrongQuizPage(){
        return "/quiz/wrong";
    }
}
