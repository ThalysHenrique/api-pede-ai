package com.api.pedeai.rest.controllers.exceptionHandler;

import com.api.pedeai.exception.PedidoNaoEncontradoException;
import com.api.pedeai.exception.ResultadoException;
import com.api.pedeai.rest.ApiErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(ResultadoException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleRegraDeNegocioException(ResultadoException ext){
        String mensagemErro = ext.getMessage();
        return new ApiErrors(mensagemErro);
    }


    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoException exception){
        String mensagemErro = exception.getMessage();
        return new ApiErrors(mensagemErro);
    }

    /* Cria uma lista de erros e mostra o erro que foi encontrado */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult().getAllErrors()
                                        .stream()
                                        .map( erro -> erro.getDefaultMessage())
                                        .collect(Collectors.toList());
                                    return new ApiErrors(errors);
    }
}
