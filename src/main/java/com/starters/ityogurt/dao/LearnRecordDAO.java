package com.starters.ityogurt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.starters.ityogurt.dto.LearnRecordDTO;
import com.starters.ityogurt.dto.QuizDTO;

@Mapper
@Repository
public interface LearnRecordDAO {

	List<LearnRecordDTO> learnData(int i);

	void learnDate(int userChoice, int isRight, int userSeq, int quizSeq);


	
}
