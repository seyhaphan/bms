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
        FIND_FAILURE("Find Data not Successfully"),
        RETRIEVE_FAILURE("Error retrieving Data with id = "),
        INSERT_FAILURE("Insert Data not Successfully"),
        DELETE_FAILURE("Can't delete Data with id = "),
        UPDATE_FAILURE("Error update Data with id = "),
        NULL_VALUE("Can't null value!");
        private String message;

        Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
