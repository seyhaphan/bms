package com.kshrd.bms.rest.restcontroller;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.rest.request.CategoryRequestModel;
import com.kshrd.bms.rest.response.BaseApiResponse;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.rest.utils.ApiUtils;
import com.kshrd.bms.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping("/categories")
    public ResponseEntity<BaseApiResponse<List<CategoryDto>>> findAll(){
        BaseApiResponse<List<CategoryDto>> response = null;

        List<CategoryDto> categories = categoryService.findAll();

        response = new BaseApiResponse<>(
                categories,
                "success",
                true);


        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> findCategoryById(@PathVariable int id){
        BaseApiResponse<CategoryDto> response = null;

        CategoryDto category = categoryService.findCategoryById(id);

        response = new BaseApiResponse<>(
                category,
                "success",
                true);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/categories")
    public ResponseEntity<BaseApiResponse<CategoryDescription>> insert(
            @RequestBody CategoryDescription categoryRequest
    ){
        BaseApiResponse<CategoryDescription> response = null;
        CategoryDto categoryDto = null;
        System.out.println(categoryRequest);
        if(categoryRequest.getName() != ""){
           categoryDto =  categoryService.insert(apiUtils.getMapper().map(categoryRequest,CategoryDto.class));
        }else{
            response.setMessage("Name Can't empty");
        }

        response = new BaseApiResponse<>(
                apiUtils.getMapper().map(categoryDto,CategoryDescription.class),
                "success",
                true);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> delete(@PathVariable int id){
        BaseApiResponse<CategoryDto> response = new BaseApiResponse<>();

       CategoryDto categoryDto = categoryService.delete(id);

        response.setMessage("Delete Success");
        response.setData(categoryDto);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<BaseApiResponse<CategoryDto>> update(
            @PathVariable int id,@RequestBody CategoryDescription category){
        BaseApiResponse<CategoryDto> response = null;

        CategoryDto categoryReq = apiUtils.getMapper().map(category,CategoryDto.class);

        CategoryDto categoryDto = categoryService.update(id,categoryReq);
        categoryDto.setId(id);

        response = new BaseApiResponse<>(
                categoryDto,
                Messages.Success.UPDATE_SUCCESS.getMessage(),
                true
        );

        return ResponseEntity.ok(response);
    }
}
