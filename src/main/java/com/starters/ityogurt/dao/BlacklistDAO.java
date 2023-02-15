package com.starters.ityogurt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.UserDTO;

@Mapper
@Repository
public interface BlacklistDAO {
	
	String insertBlackUser (String email);

}