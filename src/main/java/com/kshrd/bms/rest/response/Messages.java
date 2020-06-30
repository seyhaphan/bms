package com.kshrd.bms.rest.response;

public class Messages {
    public enum Success{
        FIND_SUCCESS("Find Data Successfully"),
        INSERT_SUCCESS("Insert Data Successfully"),
        DELETE_SUCCESS("Delete Data Successfully"),
        UPDATE_SUCCESS("Update Data Successfully"),
        FILEUPLOAD_SUCCESS("File upload successfully");
        private String message;

        Success(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public enum Error{
        FIND_FAILURE("Error Retrieving Data"),
        RETRIEVE_FAILURE("Error Retrieving Data with id = "),
        INSERT_FAILURE("Insert Data not Successfully"),
        DELETE_FAILURE("Can't delete Data with id = "),
        UPDATE_FAILURE("Error update Data with id = "),
        EMPTY_VALUE("Can not be empty!");
        private String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
