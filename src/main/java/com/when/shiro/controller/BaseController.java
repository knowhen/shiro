package com.when.shiro.controller;

import com.when.shiro.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: when
 * @create: 2018-11-29  10:33
 **/
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected ResponseData formatResponse(Object data) {
        ResponseData responseDto = new ResponseData();
        responseDto.setCode(200);
        responseDto.setMsg("success");

        if (data != null) {
            responseDto.setData(data);
        }
        logger.debug("Response is: " + responseDto);
        return responseDto;
    }

    protected ResponseData formatResponse() {
        ResponseData responseData = new ResponseData();
        responseData.setCode(200);
        responseData.setMsg("success");
        return responseData;
    }

    protected ResponseData errorResponse() {
        ResponseData responseData = new ResponseData();
        responseData.setCode(500);
        responseData.setMsg("Unknown error");
        return responseData;
    }

    protected ResponseData errorResponse(int code, String msg) {
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMsg(msg);
        return responseData;
    }
}
