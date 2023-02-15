package com.starters.ityogurt.service;

import java.util.List;

import com.starters.ityogurt.dto.UserDTO;

public interface UserService {
	
	List<UserDTO> getAllUserlist();
	
	List<UserDTO> getAllUserlistLimit(int limit);
	
	int countAllUser();
  
  public int insertUser(UserDTO dto);
  
  //public UserDTO selectUser(UserDTO dto);

}
