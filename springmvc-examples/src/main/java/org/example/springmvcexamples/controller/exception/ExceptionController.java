package org.example.springmvcexamples.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.exception.XException;
import org.example.springmvcexamples.vo.ResultVo;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(XException.class)
    public ResultVo handleXException(XException e) {
        if(e.getCode() != null){
            return ResultVo.error(e.getCode());
        }
        return ResultVo.error(e.getNumber(),e.getMessage());
    }
    //兜底异常
    @ExceptionHandler(Exception.class)
    public ResultVo handleException(Exception e) {
        return ResultVo.error(Code.ERROR,e.getMessage());
    }

}
