package com.kshrd.bms.service.impl;

import com.kshrd.bms.repository.BookRepository;
import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.rest.utils.ApiUtils;
import com.kshrd.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private ApiUtils apiUtils;
    private BookRepository bookRepository;

    @Autowired
    public void setApiUtils(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //TODO: Find all books
    @Override
    public List<BookDto> findAll() {
        List<BookDto> books = bookRepository.findAll();
        if (books.size() > 0){
            return books;
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,Messages.Error.FIND_FAILURE.getMessage());
    }

    //TODO: Find book by id
    @Override
    public BookDto findById(int id){
        BookDto book =  bookRepository.findById(id);
        if (book != null)
            return book;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,Messages.Error.RETRIEVE_FAILURE.getMessage()+id + ". Maybe book not found!");
    }

    //TODO: Insert book
    @Override
    public boolean insert(BookDto bookDto) {
        try{
            if (bookDto != null){
                boolean isInserted = bookRepository.insert(bookDto);
                if (isInserted)
                    return true;
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    Messages.Error.INSERT_FAILURE.getMessage());
        }
        return false;
    }

    //TODO: Delete book by id
    @Override
    public boolean delete(int id){
          return bookRepository.delete(id);
    }

    //TODO: Update book by id
    @Override
    public boolean update(int id, BookRequestModel book) {

        try{
            if (book != null){
                boolean isUpdated = bookRepository.update(id,book);
                if(isUpdated){
                    return true;
                }
            }

        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    Messages.Error.UPDATE_FAILURE.getMessage() + id);
        }
        return false;
    }

    //TODO: Filter book by title
    @Override
    public List<BookDto> filterBookByName(String name) {
        return bookRepository.filterBookByName(name);
    }

    //TODO: Filter book by title
    @Override
    public List<BookDto> filterBookByCategory(int categoryId) {
        return bookRepository.filterBookByCategory(categoryId);
    }

    //TODO: filter Books
    @Override
    public List<BookDto> filterBook(int categoryId, String name) {
        return bookRepository.filterBook(categoryId,name);
    }
}
