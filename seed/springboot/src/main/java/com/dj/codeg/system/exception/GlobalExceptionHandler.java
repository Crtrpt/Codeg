package com.dj.codeg.system.exception;


import com.dj.codeg.system.utils.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResultDto handlerBusinessException(BusinessException ex) {
        log.warn("异常");
        return ResultDto.Error(ex.getCode(), ex.getMessage());
    }

    /**
     * TODO 写入日志
     *
     * @param
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultDto<String> exceptionGet(Exception e) {
        e.printStackTrace();
        return ResultDto.Error(e.getMessage());
    }
}
