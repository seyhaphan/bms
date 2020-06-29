package com.kshrd.bms.repository;

import com.kshrd.bms.repository.dto.CategoryDto;
import com.kshrd.bms.repository.provider.CategoryProvider;
import com.kshrd.bms.rest.request.CategoryDescription;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository {

    @SelectProvider(type = CategoryProvider.class,method = "findAllSql")
    @Result(property = "name",column = "title")
    List<CategoryDto> findAll();

    @SelectProvider(type = CategoryProvider.class,method = "findCategoryById")
    @Result(property = "name",column = "title")
    CategoryDto findCategoryById(int id);

    @InsertProvider(type = CategoryProvider.class,method = "insertSql")
    boolean insert(CategoryDescription category);

    @UpdateProvider(type = CategoryProvider.class,method = "updateSql")
    boolean update(int id, CategoryDescription category);

    @DeleteProvider(type = CategoryProvider.class,method = "deleteSql")
    boolean delete(int id);


}
