package com.starters.ityogurt.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.starters.ityogurt.dto.KnowledgeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface EmailService {

    void send(String subject, String content, List<String> receivers);

    List<String> getAllEmails();

/*    KnowledgeDTO getSendDetail();*/

    List<String> getSendEmailsSubJava();

    void updateSendDate(int categorySeq);

    // 추가
    List<Map<String, Object>> getEmailAndSub();
    List<Map<String, Object>> getSendDetail(int count);
    KnowledgeDTO getKnowledgeByCategorySeq(int categorySeq);

}
