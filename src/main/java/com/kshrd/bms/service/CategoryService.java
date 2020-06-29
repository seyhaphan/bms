package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryRequestModel;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findCategoryById(int id);

    CategoryDto insert(CategoryDto category);

    CategoryDto delete(int id);

    CategoryDto update(int id,CategoryDto name);
}
