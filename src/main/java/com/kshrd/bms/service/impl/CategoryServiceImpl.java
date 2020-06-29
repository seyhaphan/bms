package com.kshrd.bms.service.impl;

import com.kshrd.bms.repository.CategoryRepository;
import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.rest.request.CategoryRequestModel;
import com.kshrd.bms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //TODO: find all category
    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll();
    }

    //TODO: find category by id
    @Override
    public CategoryDto findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    //TODO: Add category
    @Override
    public boolean insert(CategoryDescription category) {

        if (category.getName() != ""){
            boolean isInserted = categoryRepository.insert(category);
            if (isInserted)
                return true;
        }
        return false;
    }

    //TODO: Delete category by id
    @Override
    public CategoryDto delete(int id) {
        CategoryDto categoryDto = categoryRepository.findCategoryById(id);
        if(categoryDto != null){
            categoryRepository.delete(id);
        }
        return categoryDto;
    }

    //TODO: Update category by id
    @Override
    public boolean update(int id, CategoryDescription category) {
        if (category.getName() != "") {
            boolean isUpdated = categoryRepository.update(id,category);
            if (isUpdated) return true;
        }
        return false;
    }
}
