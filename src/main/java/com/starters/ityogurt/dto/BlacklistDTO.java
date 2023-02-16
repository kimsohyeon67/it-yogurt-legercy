package com.starters.ityogurt.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

public class BlacklistDTO { 
	
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
