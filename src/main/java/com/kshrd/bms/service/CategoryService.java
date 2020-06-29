package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findCategoryById(int id);

    boolean insert(CategoryDescription category);
    boolean update(int id,CategoryDescription name);

    CategoryDto delete(int id);


}
