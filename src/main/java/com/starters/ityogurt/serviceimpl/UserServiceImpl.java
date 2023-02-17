package com.starters.ityogurt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starters.ityogurt.dao.UserDAO;
import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO dao;
	
	@Override
	public List<UserDTO> getAllUserlist(){
		return dao.getAllUserlist();
	}
	@Override
	public List<UserDTO> getAllUserlistLimit(int limit){
		return dao.getAllUserlistLimit(limit);
	}
	@Override
	public int countAllUser(){
		return dao.countAllUser();
	}

	@Override
	public void deleteUser(int userSeq) {
		dao.deleteUser(userSeq);
	}

	@Override
	public int insertUser(UserDTO dto){
		return dao.insertUser(dto);
	}

	@Override
	public UserDTO getUserByUserEmail(String email) {
		return dao.getUserByUserEmail(email);
	}

}
