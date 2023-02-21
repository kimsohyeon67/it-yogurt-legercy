package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.LearnRecordQuizDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LearnRecordQuizDAO {
    public List<LearnRecordQuizDTO> getWrongAnswerByUser(String userSeq);
	
}
