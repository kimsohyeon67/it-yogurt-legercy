package com.starters.ityogurt.serviceimpl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.starters.ityogurt.dao.EmailDAO;
import com.starters.ityogurt.dto.EmailDTO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.service.CategoryService;
import com.starters.ityogurt.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

import lombok.RequiredArgsConstructor;

@Slf4j
@Service("emailservice")
// @AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailDAO dao;

    @Autowired
    private AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    //이메일 전송하기
    public void send(String subject, String content, List<String> receivers) {

        //이메일 정보를 담은 객체 생성
        EmailDTO emailSenderDto = new EmailDTO(receivers, subject, content);

        Future<SendEmailResult> sendEmailResultFuture = amazonSimpleEmailServiceAsync.sendEmailAsync(emailSenderDto.toSendRequestDto());

        System.out.println(sendEmailResultFuture);
    }

    @Override
    public List<String> getAllEmails() {
        return dao.getAllEmails();
    }

    @Override
    public List<String> getSendEmailsSubJava() {
        return dao.getSendEmailsSubJava();
    }

    @Override
    public void updateSendDate(int categorySeq) {
        dao.updateSendDate(categorySeq);
    }

    private void sendingResultMustSuccess(SendEmailResult sendEmailResult) {
        if (sendEmailResult.getSdkHttpMetadata().getHttpStatusCode() != 200) {
            log.error("{}", sendEmailResult.getSdkResponseMetadata().toString());
        }
    }

    // 추가
    // 유저의 이메일과 유저가 선택한 소분류를 map에 담은 것을 반환한다.
    @Override
    public List<Map<String, Object>> getEmailAndSub() {
        return dao.getEmailAndSub();
    }

    // 소분류에서 어떤 상세분류를 보낼 것인지를 map에 담아 반환한다.
    @Override
    public List<Map<String, Object>> getSendDetail(int count) {
        return dao.getSendDetail(count);
    }


}