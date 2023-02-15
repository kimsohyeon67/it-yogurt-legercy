package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.UserDTO;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository("userdao")
public interface UserDAO {
    public int InsertUser(UserDTO dto);
    public int SelectUserOne(UserDTO dto);

}
