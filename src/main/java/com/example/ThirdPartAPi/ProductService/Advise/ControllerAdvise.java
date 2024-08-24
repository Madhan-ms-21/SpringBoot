package com.example.ThirdPartAPi.ProductService.Advise;


import com.example.ThirdPartAPi.ProductService.Exceptions.CategoryNotFoundException;
import com.example.ThirdPartAPi.ProductService.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));
    }


}
