package org.example.backendexamples.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.backendexamples.exception.Code;
import org.example.backendexamples.exception.XException;
import org.example.backendexamples.vo.ResultVo;
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
        log.error(e.getMessage());
        return ResultVo.error(e.getNumber(),e.getMessage());
    }
    //兜底异常
    @ExceptionHandler(Exception.class)
    public ResultVo handleException(Exception e) {
        log.error(e.getMessage());
        return ResultVo.error(Code.ERROR,e.getMessage());
    }

}
