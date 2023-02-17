package com.starters.ityogurt.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CategoryDTO {
   String categorySeq;
   String main;
   String middle;
   String sub;
   String detail;
}
