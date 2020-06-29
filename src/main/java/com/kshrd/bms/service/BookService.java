package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.rest.response.BookResponseModel;

import java.util.List;

public interface BookService {

    List<BookDto> findAll();
    BookDto findById(int id);
    boolean insert(BookDto bookDto);
    boolean delete(int id);
    boolean update(int id, BookRequestModel book);
    List<BookDto> filterBookByName(String name);
    List<BookDto> filterBookByCategory(int categoryId);

    List<BookDto> filterBookBySql(int id,String name);
    List<BookDto> filterBook(int categoryId,String name);
}
