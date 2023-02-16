package com.starters.ityogurt.dao;

import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmailDAO {
    List<String> getAllEmails();
    List<String> getSendEmailsSubJava();
    KnowledgeDTO getSendDetail();

    void updateSendDate(int categorySeq);


    void getDetailBySub(String sub);

    void getEmailByUser(int userSeq);
}
