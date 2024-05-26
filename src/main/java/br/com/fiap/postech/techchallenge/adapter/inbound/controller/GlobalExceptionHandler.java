package br.com.fiap.postech.techchallenge.adapter.inbound.controller;

import br.com.fiap.postech.techchallenge.application.exception.DominioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DominioException.class)
    public ResponseEntity<String> handleDuplicateRecordException(DominioException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorResponse(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    public static class ErrorResponse {
        private List<String> erros;

        public ErrorResponse(List<String> erros) {
            this.erros = erros;
        }

        public List<String> getErros() {
            return erros;
        }

        public void setErros(List<String> erros) {
            this.erros = erros;
        }
    }
}
