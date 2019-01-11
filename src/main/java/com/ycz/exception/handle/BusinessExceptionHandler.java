package com.ycz.exception.handle;

import com.ycz.exception.BusinessException;
import com.ycz.model.bo.RestResponseBo;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 */
@ControllerAdvice
@Order(1)
public class BusinessExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public RestResponseBo handleBusinessException(BusinessException e) {
        if(e instanceof BusinessException) {
            return RestResponseBo.fail(e.getMessage());
        }else{
            return RestResponseBo.fail("error");
        }
    }
}
