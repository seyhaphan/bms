package com.kshrd.bms.rest.restcontroller;

import com.kshrd.bms.repository.dto.BookDto;
import com.kshrd.bms.rest.request.BookRequestModel;
import com.kshrd.bms.rest.response.BaseApiResponse;
import com.kshrd.bms.rest.response.BookResponseModel;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.rest.utils.ApiUtils;
import com.kshrd.bms.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRestController {
    private ApiUtils apiUtils;
    private BookServiceImpl bookService;

    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setApiUtils(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    //TODO: Find all books
    @GetMapping("/books")
    public ResponseEntity<BaseApiResponse<List<BookResponseModel>>> findAll(){
        BaseApiResponse<List<BookResponseModel>> response = null;
        //Get all book from service

        List<BookDto> books = bookService.findAll();
        //Map book model to book response model

        List<BookResponseModel> bookResponse = new ArrayList<>();

        for (BookDto book : books){
            bookResponse.add(apiUtils.getMapper().map(book,BookResponseModel.class));
        }

        response = new BaseApiResponse<>(
                bookResponse,
                Messages.Success.FIND_SUCCESS.getMessage(),
                true);

        return ResponseEntity.ok(response);
    }

    //TODO: Find book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookResponseModel>> findById(
            @PathVariable Integer id){

        BaseApiResponse<BookResponseModel> response = null;

        BookDto book = bookService.findById(id);

        if (book != null){
            response = new BaseApiResponse<>(
                    apiUtils.getMapper().map(book,BookResponseModel.class),
                    Messages.Success.FIND_SUCCESS.getMessage(),
                    true);
        }else {
            response = new BaseApiResponse<>(
                    Messages.Error.RETRIEVE_FAILURE.getMessage()+id,
                    false
            );
        }

        return ResponseEntity.ok(response);
    }

    //TODO: insert book
    @PostMapping("/books")
    public ResponseEntity<BaseApiResponse<BookRequestModel>> insert(
            @RequestBody BookRequestModel bookRequestModel){

        BaseApiResponse<BookRequestModel> response = null;

        boolean isInserted = bookService.insert(apiUtils.getMapper().map(bookRequestModel,BookDto.class));
        if (isInserted)
            response = new BaseApiResponse<>(
                bookRequestModel,
                Messages.Success.INSERT_SUCCESS.getMessage(),
                true);

        return ResponseEntity.ok(response);
    }

    //TODO: Delete book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookResponseModel>> delele(@PathVariable int id) throws Exception {
        BaseApiResponse<BookResponseModel> response = null;

        BookDto bookDto = bookService.findById(id);

        boolean isDeleted = bookService.delete(id);

        if (isDeleted){
            response = new BaseApiResponse<>(
                    apiUtils.getMapper().map(bookDto,BookResponseModel.class),
                    Messages.Success.DELETE_SUCCESS.getMessage(),
                    true);
        }else{
            response = new BaseApiResponse<>(
                    Messages.Error.DELETE_FAILURE.getMessage()+ id + ". Maybe book not found!",
                    false);
        }

        return ResponseEntity.ok(response);
    }

    //TODO: Update book
    @PutMapping("/books/{id}")
    public ResponseEntity<BaseApiResponse<BookResponseModel>> update(
            @PathVariable int id,@RequestBody BookRequestModel bookRequestModel
    ){
        BaseApiResponse<BookResponseModel> response = null;

        boolean isUpdated = bookService.update(id,bookRequestModel);
        if (isUpdated){
            response = new BaseApiResponse<>(
                    apiUtils.getMapper().map(bookService.findById(id),BookResponseModel.class),
                    Messages.Success.UPDATE_SUCCESS.getMessage(),
                    true);
        }else{
            response = new BaseApiResponse<>(
                    Messages.Error.UPDATE_FAILURE.getMessage() + id +". Maybe book not found!",
                    false);
        }

        return ResponseEntity.ok(response);
    }

    //TODO: Filter by title
    @GetMapping(path ="/books",params = "name")
    public ResponseEntity<BaseApiResponse<List<BookResponseModel>>> filterByName(
            @RequestParam String name
    ){
        BaseApiResponse<List<BookResponseModel>> response = null;
        List<BookResponseModel> bookResponse = new ArrayList<>();
        List<BookDto> books =bookService.filterBookByName(name);

        if (books.size() > 0){
            for (BookDto book : books){
                bookResponse.add(apiUtils.getMapper().map(book,BookResponseModel.class));
            }
            response = new BaseApiResponse<>(
                bookResponse,
                Messages.Success.FIND_SUCCESS.getMessage(),
                true);
        }else{
            response = new BaseApiResponse<>(
        Messages.Error.FIND_FAILURE.getMessage()+". Maybe book not found!",
        false);
        }

        return ResponseEntity.ok(response);
    }

    //TODO: Filter by title
    @GetMapping(path = "/books",params = "categoryId")
    public ResponseEntity<BaseApiResponse<List<BookResponseModel>>> filterByCategory(
            @RequestParam int categoryId
    ){
        BaseApiResponse<List<BookResponseModel>> response = null;
        List<BookResponseModel> bookResponse = new ArrayList<>();
        List<BookDto> books =bookService.filterBookByCategory(categoryId);

        if (books.size() > 0){
            for (BookDto book : books){
                bookResponse.add(apiUtils.getMapper().map(book,BookResponseModel.class));
            }
            response = new BaseApiResponse<>(
                    bookResponse,
                    Messages.Success.FIND_SUCCESS.getMessage(),
                    true);
        }else{
            response = new BaseApiResponse<>(
                    Messages.Error.FIND_FAILURE.getMessage()+". Maybe book not found!",
                    false);
        }

        return ResponseEntity.ok(response);
    }

    //TODO: filter by categoryID and name
    @ApiIgnore
    @GetMapping(path ="/books", params ={"categoryId","name"})
    public ResponseEntity<BaseApiResponse<List<BookResponseModel>>> filterBooks(
        @RequestParam int categoryId,
        @RequestParam String name
    ){

        BaseApiResponse<List<BookResponseModel>> response = null;

        List<BookResponseModel> bookResponse = new ArrayList<>();

        List<BookDto> books =bookService.filterBook(categoryId,name);
        if (books.size() > 0){
            for (BookDto book : books){
                bookResponse.add(apiUtils.getMapper().map(book,BookResponseModel.class));
            }
            response = new BaseApiResponse<>(
                    bookResponse,
                    Messages.Success.FIND_SUCCESS.getMessage(),
                    true);
        }else{
            response = new BaseApiResponse<>(
                    Messages.Error.FIND_FAILURE.getMessage()+". Maybe book not found!",
                    false);
        }
        return ResponseEntity.ok(response);
    }
}
