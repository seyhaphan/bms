package com.kshrd.bms.repository;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.repository.provider.BookProvider;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.utilities.Pagination;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    //TODO: Find All Books
    @SelectProvider(type = BookProvider.class,method = "findAllSql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" , column = "cid"),
            @Result(property = "category.name", column = "c_title")
    })
    List<BookDto> findAll(@Param("pagination")Pagination pagination);

    //TODO: Count All books
    @Select("SELECT COUNT(*) FROM tb_books")
    int totalCount();

    //TODO: Find Book By Id
    @SelectProvider(type = BookProvider.class,method = "findById")
    @Results({
            @Result(property = "name",column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    BookDto findById(int id);

    //TODO: Insert Book
    @InsertProvider(type = BookProvider.class,method = "insertSql")
    boolean insert(BookDto book);

    //TODO: Delete Book By Id
    @DeleteProvider(type = BookProvider.class,method = "deleteSql")
    boolean delete(int id);

    //TODO: Update Book By Id
    @UpdateProvider(type = BookProvider.class,method = "updateSql")
    boolean update(int id, BookRequestModel book) throws Exception;

    //TODO: Filter Books By Name
    @SelectProvider(type = BookProvider.class,method = "filterByNameSql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBookByName(String name);

    //TODO: Filter Books By Category
    @SelectProvider(type = BookProvider.class,method = "filterByCategorySql")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBookByCategory(int categoryId);

    //TODO: Filter Books by Category and Name
    @SelectProvider(type = BookProvider.class,method = "filterBook")
    @Results({
            @Result(property = "name", column = "title"),
            @Result(property = "category.id" ,column = "cid"),
            @Result(property = "category.name",column = "c_title")
    })
    List<BookDto> filterBook(int categoryId,String name);
}
