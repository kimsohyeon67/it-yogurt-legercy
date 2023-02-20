package com.starters.ityogurt.service;

import com.starters.ityogurt.dto.KnowledgeDTO;

import java.util.List;
import java.util.Map;

public interface EmailService {

    void send(String subject, String content, List<String> receivers);

    List<String> getAllEmails();

/*    KnowledgeDTO getSendDetail();*/

    List<String> getSendEmailsSubJava();

    void updateSendDate(List<Object> updateCategorySeqList);

    // 추가
    List<Map<String, Object>> getEmailAndSub();
    List<Map<String, Object>> getSendDetail(int count);
    KnowledgeDTO getKnowledgeByCategorySeq();

}
