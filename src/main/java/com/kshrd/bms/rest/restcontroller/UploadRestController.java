package com.kshrd.bms.rest.restcontroller;

import com.kshrd.bms.rest.response.BaseApiResponse;
import com.kshrd.bms.rest.response.Messages;
import com.kshrd.bms.service.impl.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class UploadRestController {

    private FileUploadServiceImpl fileUploadService;

    @Autowired
    public UploadRestController(FileUploadServiceImpl fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public ResponseEntity<BaseApiResponse<String>> uploadFile(
            @RequestParam("file")MultipartFile fileUpload,
            HttpServletRequest request) throws IOException {

            String url =  fileUploadService.uploadFile(fileUpload,request);

            BaseApiResponse<String> response = new BaseApiResponse<>(
                    url,
                    Messages.Success.FILEUPLOAD_SUCCESS.getMessage(),
                    true
            );

        return ResponseEntity.ok(response);
    }

}
