package com.kshrd.bms.rest.restcontroller;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.rest.response.BaseApiResponse;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.rest.utils.ApiUtils;
import com.kshrd.bms.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {

    private CategoryServiceImpl categoryService;
    private ApiUtils apiUtils;

    @Autowired
    public void setApiUtils(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    @Autowired
    public CategoryRestController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    //TODO: find all category
    @GetMapping("/categories")
    public ResponseEntity<BaseApiResponse<List<CategoryDto>>> findAll(){

        List<CategoryDto> categories = categoryService.findAll();

        BaseApiResponse<List<CategoryDto>>  response = new BaseApiResponse<>(
                categories,
                Messages.Success.FIND_SUCCESS.getMessage(),
                true);

        return ResponseEntity.ok(response);
    }

    //TODO: find category by id
    @GetMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> findCategoryById(@PathVariable int id){

        CategoryDto category = categoryService.findCategoryById(id);

        BaseApiResponse<CategoryDto>  response = new BaseApiResponse<>(
                category,
                Messages.Success.FIND_SUCCESS.getMessage(),
                true);

        return ResponseEntity.ok(response);
    }

    //TODO: Add Category
    @PostMapping("/categories")
    public ResponseEntity<BaseApiResponse<CategoryDescription>> insert(
            @RequestBody CategoryDescription category
    ){
        BaseApiResponse<CategoryDescription> response = null;
        boolean isInserted = categoryService.insert(category);

        if (isInserted){
            response = new BaseApiResponse<>(
                category,
                Messages.Success.INSERT_SUCCESS.getMessage(),
                true);
        }

        return ResponseEntity.ok(response);
    }

    //TODO: Delete category by id
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> delete(
            @PathVariable int id){

        CategoryDto category = categoryService.delete(id);

        BaseApiResponse<CategoryDto> response = new BaseApiResponse<>(
                category,
                Messages.Success.DELETE_SUCCESS.getMessage(),
                true);

        return ResponseEntity.ok(response);
    }

    //TODO: Update category by id
    @PutMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> update(
            @PathVariable int id,
            @RequestBody CategoryDescription category){

        categoryService.update(id,category);

        BaseApiResponse<CategoryDto>  response = new BaseApiResponse<>(
                    categoryService.findCategoryById(id),
                    Messages.Success.UPDATE_SUCCESS.getMessage(),
                    true);

        return ResponseEntity.ok(response);
    }
}
