package com.kshrd.bms.service.impl;

import com.kshrd.bms.repository.CategoryRepository;
import com.kshrd.bms.repository.dto.CategoryDto;
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


    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDto findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public CategoryDto insert(CategoryDto category) {
        boolean isInserted = categoryRepository.insert(category);
        return isInserted ? category : null;
    }


    @Override
    public CategoryDto delete(int id) {
        CategoryDto categoryDto = categoryRepository.findCategoryById(id);
        if(categoryDto != null){
            categoryRepository.delete(id);
        }
        return categoryDto;
    }

    @Override
    public CategoryDto update(int id, CategoryDto category) {
        CategoryDto found = categoryRepository.findCategoryById(id);
        if (found == null) {
          return null;
        }else {
            boolean isUpdated = categoryRepository.update(id,category);
            return isUpdated ? category : null;
        }
    }
}
