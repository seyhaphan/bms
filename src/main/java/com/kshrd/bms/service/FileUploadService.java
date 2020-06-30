package com.kshrd.bms.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

    //Upload File
    String uploadFile(MultipartFile fileUpload, HttpServletRequest request);

}
