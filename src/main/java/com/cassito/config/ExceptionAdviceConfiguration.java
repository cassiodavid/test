package com.cassito.config;

import com.cassito.expection.RoboCoordenadaException;
import main.openapi.openapi.model.GeneralError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdviceConfiguration {

    @ResponseBody
    @ExceptionHandler(RoboCoordenadaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GeneralError notFoundHandler(RoboCoordenadaException e) {
        GeneralError generalError = new GeneralError();
        generalError.setCode(404);
        generalError.setMessage(e.getMessage());
        return generalError;
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public GeneralError handleIllegalArgumentException(IllegalArgumentException ex) {
        GeneralError generalError = new GeneralError();
        generalError.setCode(400);
        generalError.setMessage(ex.getMessage());
        return generalError;
    }

}