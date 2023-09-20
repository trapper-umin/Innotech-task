package innotech.com.controllers.advice;

import innotech.com.dto.responses.ErrorResp;
import innotech.com.util.exception.NotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StringControllerAdvice {

    @ExceptionHandler(NotValidException.class)
    private ResponseEntity<ErrorResp> handleException(NotValidException e){

        return ResponseEntity.badRequest().body(
                new ErrorResp
                        .Builder()
                        .message(e.getMessage())
                        .build()
        );
    }
}