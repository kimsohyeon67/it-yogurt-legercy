package com.starters.ityogurt.controller;

import com.starters.ityogurt.dto.CategoryDTO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.error.ApiException;
import com.starters.ityogurt.service.CategoryService;
import com.starters.ityogurt.service.UserService;
import com.starters.ityogurt.util.Encrypt;
import com.starters.ityogurt.error.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    @Qualifier("userservice")
    UserService userService;
    @Autowired
    @Qualifier("categoryservice")
    CategoryService categoryService;

    // 회원가입
    @PostMapping("/user/1")
    public Object SignUp(UserDTO userDTO, CategoryDTO categoryDTO) throws Exception, ApiException {
        UserDTO isEmailValid = userService.getUserByUserEmail(userDTO.getEmail());
        if (isEmailValid != null) {
            throw new ApiException(ErrorCode.SIGNUP_INVALID_EMAIL);
        }
        CategoryDTO selectedCategory = categoryService.getCategoryByAllType(
            categoryDTO.getMain(), categoryDTO.getMiddle(), categoryDTO.getSub());

        if (userDTO.getPassword() != null) {
            userDTO.setPassword(ConvertPassword(userDTO.getPassword()));
        }

        userDTO.setCategorySeq(selectedCategory.getCategorySeq());
        int result = userService.insertUser(userDTO);
        return true;
    }

    // 로그인
    @PostMapping("/user")
    public String Login(UserDTO dto, HttpServletRequest request) throws Exception {
        String error = "";

        UserDTO result = userService.getUserByUserEmail(dto.getEmail());
        if (result == null) {
            throw new ApiException(ErrorCode.SIGNIN_INVALID_EMAIL);
        } else if (result.getPassword() == null || result.getPassword().equals("")) {
            throw new ApiException(ErrorCode.SIGNIN_INVALID_OAUTHUSER);
        } else {
            String pw = ConvertPassword(dto.getPassword());
            if (pw.equals(result.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user_seq", result.getUserSeq());
            } else {
                throw new ApiException(ErrorCode.SIGNIN_INVALID_PASSWORD);
            }
        }
        return "로그인 성공";
    }
    
    // 로그아웃 임시(작동은 하나 오류남)
    @GetMapping("/user/o")
    public void logout(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
    }
    

    // 비밀번호 암호화
    String ConvertPassword(String pw) throws Exception {
        Encrypt crypto = new Encrypt();
        pw = crypto.encryptAES256(pw);
        return pw;
    }
    //endregion
}
