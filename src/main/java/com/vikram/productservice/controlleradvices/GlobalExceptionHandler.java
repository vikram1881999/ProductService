package com.vikram.productservice.controlleradvices;

import com.vikram.productservice.dtos.ProductNotFoundDTO;
import com.vikram.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundDTO> handleProductNotFoundException() {
        ProductNotFoundDTO productNotFoundDTO = new ProductNotFoundDTO();
        productNotFoundDTO.setMessage("Product Not Found with this ID");
        productNotFoundDTO.setResolution("Try passing valid productID");
        return new ResponseEntity<>(
                productNotFoundDTO,
                HttpStatus.NOT_FOUND
        );
    }


    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Void> handleRuntimeException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<Void> handleArrayIndexOutOfBoundsException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
