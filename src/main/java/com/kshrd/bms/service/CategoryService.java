package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.utilities.Pagination;

import java.util.List;

public interface CategoryService {

    //Find All Category
    List<CategoryDto> findAll(Pagination pagination);

    //Count All Category
    int totalCount();

    //Find Category By Id
    CategoryDto findCategoryById(int id);

    //Insert Category
    boolean insert(CategoryDescription category);

    //Update Exist Category By Id
    boolean update(int id,CategoryDescription name);

    //Delete Category By Id
    CategoryDto delete(int id);

}
