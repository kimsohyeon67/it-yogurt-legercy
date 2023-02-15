package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.UserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
	
	List<UserDTO> getAllUserlist();
	
	List<UserDTO> getAllUserlistLimit(int limit);

	int countAllUser();
	
	void deleteUser(int userSeq);
  
  public int InsertUser(UserDTO dto);
  
  public int SelectUserOne(UserDTO dto);
}
