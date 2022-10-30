//package com.springbootdemo.crudExample.Exception;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
////import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//
//
//
//
//@ControllerAdvice
//public class GlobalHandler extends ResponseEntityExceptionHandler{
//	
//	@Value("${exception.msg1:Default Message}")
//
//    private String msg1;
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleNotValidException(MethodArgumentNotValidException ex){
////        log.warn(msg1);
//        return new ResponseEntity<String>(msg1,HttpStatus.BAD_REQUEST);
//
//    }
//    @Value("${exception.msg2:Default Message}")
//    private String msg2;
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleNoSuch(NullPointerException ex){
////        log.warn(msg2);
//        return new ResponseEntity<String>(msg2,HttpStatus.BAD_REQUEST);
//
//    }
//    @Value("${exception.msg3:Default Message}")
//    private String msg3;
//    @ExceptionHandler(EmptyResultDataAccessException.class)
//    public ResponseEntity<String> handleEmptyResult(EmptyResultDataAccessException ex){
////        log.warn(msg3);
//        return new ResponseEntity<String>(msg3,HttpStatus.NOT_FOUND);
//
//    }
//
//
//	
//	@Override
//	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
//			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
//		// TODO Auto-generated method stub
//		return new ResponseEntity<Object>("Change your Http Request Type",HttpStatus.NOT_FOUND);
//		
//	}
//
//	
//
//}
//
//
//
//
//
//
//
////@ExceptionHandler(EmptyInputException.class)
////public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException)
////{
////	return new ResponseEntity<String>("Input field is Empty",HttpStatus.BAD_REQUEST);    	
////}
//
//
////
////@ExceptionHandler(value = NoSuchElementException.class)
////public ResponseEntity<String> handleNosuchElementException(NoSuchElementException elementException)
////{
////	return new ResponseEntity<String>("No value is present in the database. Please,check!",HttpStatus.NOT_FOUND);
////}
//
////@ExceptionHandler(value = NullPointerException.class)
////public String handleNullPointerException(Model model)
////{
////	model.addAttribute("Error","Some Problem Occurred");
////	return "error";
////}
////
////@ExceptionHandler(Exception.class)
////public ResponseEntity<Object> handleGlobalException(Exception exception, WebRequest request)
////{
////   ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
////   return new ResponseEntity<Object>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
////}
////
