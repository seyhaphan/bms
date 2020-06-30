package com.kshrd.bms.service;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.rest.request.BookRequestModel;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BookService {
    @PreAuthorize("hasRole('ROLE_USER')")
    List<BookDto> findAll();

    BookDto findById(int id);

    boolean insert(BookDto bookDto);
    boolean delete(int id);
    boolean update(int id, BookRequestModel book);

    List<BookDto> filterBookByName(String name);
    List<BookDto> filterBookByCategory(int categoryId);
    List<BookDto> filterBook(int categoryId,String name);
}
