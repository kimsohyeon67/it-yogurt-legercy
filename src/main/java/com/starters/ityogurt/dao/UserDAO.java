package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.UserDTO;
import com.starters.ityogurt.util.Criteria;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
	
	List<UserDTO> getAllUserlist();
	
	List<UserDTO> getAllUserlistLimit(Criteria cri);

	int countAllUser();
	
	void deleteUser(int userSeq);
  
	int insertUser(UserDTO dto);

	UserDTO getUserByUserEmail(String email);

	Integer setIsPassByUserSeq(int userSeq);

	int setAttendanceByUserSeq(int userSeq, int attendance);

	int setLastLoginDateByUserSeq(int userSeq);
}

