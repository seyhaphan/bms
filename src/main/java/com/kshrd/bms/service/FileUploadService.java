package com.kshrd.bms.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface FileUploadService {

    String uploadFile(MultipartFile fileUpload, HttpServletRequest request) throws IOException;

}
