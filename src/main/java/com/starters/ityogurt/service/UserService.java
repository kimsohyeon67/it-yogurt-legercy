package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.util.Criteria;

public interface UserService {
	
	List<UserDTO> getAllUserlist();
	
	List<UserDTO> getAllUserlistLimit(Criteria cri);
	
	int countAllUser();
  
	int insertUser(UserDTO dto);

	void deleteUser(int userSeq);

	UserDTO getUserByUserEmail(String email);

	int setIsPassByUserSeq(int userSeq);
}
