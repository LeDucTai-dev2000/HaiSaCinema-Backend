package com.Constant;

public interface Constant {

	String SUCCESS = "Success";
    String ERR = "error";
    String NOT_FOUND = "DATA NOT FOUND!";
    String INTERAL_SERVER_ERROR = "Internal Server Error. Please Contact Your Author!";
    String BAD_REQUEST = "Bad request -  Request Param wrong or is required";
    String UNEXPECTED_ERR  = "An error occurr";
    String SENDING_ERR = "Email entered not exist";

    interface Exception{
        String URI = "Exception_uri";
        String STATUS_CODE = "Status_code";
        String MESSAGE = "Data already exists";
    }
    interface Method {
        String GET = "GET";
        String POST = "POST";
    }
}
