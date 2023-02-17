package com.starters.ityogurt.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class LearnRecordDTO {
	int learnSeq, isRight, userSeq, quizSeq;
	String userChoice;
}
