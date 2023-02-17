package com.starters.ityogurt.service;

import com.starters.ityogurt.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategoryList();
    CategoryDTO getCategoryByCategorySeq(String categorySeq);
}
