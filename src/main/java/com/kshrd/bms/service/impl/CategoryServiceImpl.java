package com.kshrd.bms.service.impl;

import com.kshrd.bms.repository.CategoryRepository;
import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        List<CategoryDto> getCategories = categoryRepository.findAll();
        if (getCategories.size() > 0){
            return getCategories;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,Messages.Error.FIND_FAILURE.getMessage()+".Maybe data not found!");
        }
    }

    //TODO: find category by id
    @Override
    public CategoryDto findCategoryById(int id) {
        CategoryDto category = categoryRepository.findCategoryById(id);
        if (category != null){
            return category;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,Messages.Error.RETRIEVE_FAILURE.getMessage()+id+".Maybe data not found!");
        }

    }

    //TODO: Add category
    @Override
    public boolean insert(CategoryDescription category) {
        if (category.getName() != "" && category.getName() != null){
            boolean isInserted = categoryRepository.insert(category);
            if (isInserted)
                return true;
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,Messages.Error.EMPTY_VALUE.getMessage());
            }
        }else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,Messages.Error.INSERT_FAILURE.getMessage());

    }

    //TODO: Delete category by id
    @Override
    public CategoryDto delete(int id) {
        CategoryDto categoryDto = categoryRepository.findCategoryById(id);
        if(categoryDto != null){
            categoryRepository.delete(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.Error.DELETE_FAILURE.getMessage()+id);
        }
        return categoryDto;
    }

    //TODO: Update category by id
    @Override
    public boolean update(int id, CategoryDescription category) {
        if (category.getName() != "" && category.getName()!= null) {
            boolean isUpdated = categoryRepository.update(id,category);
            if (isUpdated) return true;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,Messages.Error.UPDATE_FAILURE.getMessage()+id);
        }
        return false;
    }
}
