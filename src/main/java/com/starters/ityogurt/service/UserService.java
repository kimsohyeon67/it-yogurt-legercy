package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.UserDTO;

public interface UserService {
	
	List<UserDTO> getAllUserlist();
	
	List<UserDTO> getAllUserlistLimit(int limit);
	
	int countAllUser();
  
	int insertUser(UserDTO dto);

	void deleteUser(int userSeq);

	UserDTO getUserByUserEmail(String email);

}
