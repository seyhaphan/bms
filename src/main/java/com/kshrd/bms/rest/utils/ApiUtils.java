package com.kshrd.bms.rest.utils;

import com.kshrd.bms.rest.response.BaseApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ApiUtils {

    public ModelMapper getMapper(){
        return new ModelMapper();
    }

    public Timestamp getTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

}
