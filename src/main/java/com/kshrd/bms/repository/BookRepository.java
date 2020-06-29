package com.kshrd.bms.repository;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.repository.provider.BookProvider;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.rest.response.Messages;
import org.apache.ibatis.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface BookRepository {

    @SelectProvider(type = BookProvider.class,method = "findAllSql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" , column = "cid"),
            @Result(property = "category.name", column = "c_title")
    })
    List<BookDto> findAll();

    @SelectProvider(type = BookProvider.class,method = "findById")
    @Results({
            @Result(property = "name",column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    BookDto findById(int id);

    @InsertProvider(type = BookProvider.class,method = "insertSql")
    boolean insert(BookDto book) throws Exception;

    @DeleteProvider(type = BookProvider.class,method = "deleteSql")
    boolean delete(int id);

    @UpdateProvider(type = BookProvider.class,method = "updateSql")
    boolean update(int id, BookRequestModel book) throws Exception;

    @SelectProvider(type = BookProvider.class,method = "filterByNameSql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBookByName(String name);

    @SelectProvider(type = BookProvider.class,method = "filterByCategorySql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBookByCategory(int categoryId);

    @SelectProvider(type = BookProvider.class,method = "filterBook")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBook(int categoryId,String name);
}
