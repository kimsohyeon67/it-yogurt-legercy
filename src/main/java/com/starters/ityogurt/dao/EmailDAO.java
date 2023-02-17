package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmailDAO {
    List<String> getAllEmails();
}
