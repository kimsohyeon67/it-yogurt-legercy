package com.starters.ityogurt.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CategoryDTO {
   String category_seq;
   String main;
   String middle;
   String sub;
   String detail;
}
