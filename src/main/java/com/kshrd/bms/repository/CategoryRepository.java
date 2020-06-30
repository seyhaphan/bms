package com.kshrd.bms.repository;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.repository.provider.CategoryProvider;
import com.kshrd.bms.rest.request.CategoryDescription;
import com.kshrd.bms.utilities.Pagination;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository {

    //TODO: Find All Category
    @SelectProvider(type = CategoryProvider.class,method = "findAllSql")
    @Result(property = "name",column = "title")
    List<CategoryDto> findAll(@Param("pagination")Pagination pagination);

    //TODO: Count All Category
    @Select("SELECT COUNT(*) FROM tb_categories")
    int totalCount();

    //TODO: Find Category By Id
    @SelectProvider(type = CategoryProvider.class,method = "findCategoryById")
    @Result(property = "name",column = "title")
    CategoryDto findCategoryById(int id);

    //TODO: Insert Category
    @InsertProvider(type = CategoryProvider.class,method = "insertSql")
    boolean insert(CategoryDescription category);

    //TODO: Update Category By Id
    @UpdateProvider(type = CategoryProvider.class,method = "updateSql")
    boolean update(int id, CategoryDescription category);

    //TODO: Delete Category By Id
    @DeleteProvider(type = CategoryProvider.class,method = "deleteSql")
    boolean delete(int id);


}
