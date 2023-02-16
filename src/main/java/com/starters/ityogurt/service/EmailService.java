package com.starters.ityogurt.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmailService {

    void send(String subject, String content, List<String> receivers);

    List<String> getAllEmails();


}
