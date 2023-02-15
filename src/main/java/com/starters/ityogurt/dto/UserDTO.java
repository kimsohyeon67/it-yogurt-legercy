package com.starters.ityogurt.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDTO {

//region UserDTO 변수
    int userSeq;
    String email;
    String nickname;
    Date insertDate;
    String image;
    String admin;
    int allQuizCount;
    String phone;
    Date lastLoginDate;
    int attendance;
    int categorySeq;
    boolean isPass;
    String password;
    String accessToken;
    String refreshToken;
//endregion

}
