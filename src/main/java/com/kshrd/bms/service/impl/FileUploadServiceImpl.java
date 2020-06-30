package com.kshrd.bms.service.impl;

import com.kshrd.bms.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String uploadFile(MultipartFile fileUpload,HttpServletRequest request){
        String pathUpload = "uploads";
        String fileName = "";
        try {

            String path = request.getServletContext().getRealPath("/");

            File files = new File(path + pathUpload);
            if (!files.exists()){
                files.mkdir();
            }

            fileName = UUID.randomUUID()+fileUpload.getOriginalFilename();

            fileUpload.transferTo(new File(files.getPath()+File.separator+fileName));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+pathUpload+"/"+fileName;
    }
}
