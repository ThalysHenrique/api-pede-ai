package com.api.pedeai.rest.controllers.exceptionHandler;

import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ResultadoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraDeNegocioException(ResultadoException ext){
        String mensagemErro = ext.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
