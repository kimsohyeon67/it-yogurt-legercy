package com.starters.ityogurt.serviceimpl;

import java.util.List;

import com.starters.ityogurt.dao.EmailDAO;
import com.starters.ityogurt.dto.EmailDTO;
import com.starters.ityogurt.dto.KnowledgeDTO;
import com.starters.ityogurt.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

import lombok.RequiredArgsConstructor;

@Slf4j
@Service("emailservice")
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailDAO dao;

    @Autowired
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    //이메일 전송하기
    public void send(String subject, String content, List<String> receivers) {

        //이메일 정보를 담은 객체 생성
        EmailDTO emailSenderDto = new EmailDTO(receivers, subject, content);

        //EmailSenderDto를 SendEmailRequest형태로 바꿔준후 이메일 전송.
        SendEmailResult sendEmailResult = amazonSimpleEmailService.sendEmail(emailSenderDto.toSendRequestDto());

        System.out.println(sendEmailResult.getSdkResponseMetadata().toString());

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
    public KnowledgeDTO getSendDetail() {
        return dao.getSendDetail();
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

}