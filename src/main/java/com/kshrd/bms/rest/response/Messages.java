package com.kshrd.bms.rest.response;

public class Messages {
    public enum Success{
        FIND_SUCCESS("Find Book Successfully"),
        INSERT_SUCCESS("Insert Book Successfully"),
        DELETE_SUCCESS("Delete Book Successfully"),
        UPDATE_SUCCESS("Update Book Successfully");
        private String message;

        Success(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public enum Error{
        FIND_FAILURE("Find Book not Successfully"),
        RETRIEVE_FAILURE("Error retrieving Book with id = "),
        INSERT_FAILURE("Insert Book not Successfully"),
        DELETE_FAILURE("Can't delete book with id = "),
        UPDATE_FAILURE("Error update book with id = ");
        private String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
