package com.spring.project.http.hendler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice(basePackages = "com/spring/project/http/controller")
public class ControllerExceptionHandler /* extends ResponseEntityExceptionHandler */ {

    @ExceptionHandler({Exception.class})
    public String handleExceptions(Exception exception, HttpServletRequest request){
        log.error("Fail to return response",exception);
        return "error/error500";
    }

}
