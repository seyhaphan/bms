package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.utilities.Pagination;

import java.util.List;

public interface BookService {

    //Find All Books
    List<BookDto> findAll(Pagination pagination);

    //Count All Books
    int totalCount();

    //Find Books By Id
    BookDto findById(int id);

    //Insert Book
    boolean insert(BookDto bookDto);

    //Delete Book By Id
    boolean delete(int id);

    //Update exist Book By Id
    boolean update(int id, BookRequestModel book);

    //Filter Books By Name
    List<BookDto> filterBookByName(String name);

    //Filter Books By Category
    List<BookDto> filterBookByCategory(int categoryId);

    //Filter Books By Category and Name
    List<BookDto> filterBook(int categoryId,String name);
}
