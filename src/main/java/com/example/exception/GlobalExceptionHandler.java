//package com.example.exception;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import com.example.entity.ErrorResponse;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
// 
//        BindingResult bindingResult = ex.getBindingResult();
//
//        // Create a list of validation errors
//        List<String> errors = bindingResult.getAllErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.toList());
//
//        // Create an error response object
//        ErrorResponse errorResponse = new ErrorResponse("Validation failed", errors);
//
//        return errorResponse;
//    }
//
//}
//
