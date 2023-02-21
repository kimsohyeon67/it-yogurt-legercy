package com.starters.ityogurt.service;

import com.starters.ityogurt.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategoryList();
    CategoryDTO getCategoryByCategorySeq(String categorySeq);
    int countAllSub();

    List<CategoryDTO> getCategoryByType(String type, String typeValue);
    CategoryDTO getCategoryByAllType(String main, String middle, String sub);


}
