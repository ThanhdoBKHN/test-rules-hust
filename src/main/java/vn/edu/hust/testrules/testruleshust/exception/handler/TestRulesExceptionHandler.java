package vn.edu.hust.testrules.testruleshust.exception.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.edu.hust.testrules.testruleshust.exception.response.ErrorResponse;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class TestRulesExceptionHandler extends ResponseEntityExceptionHandler {

  private final String RESULT_NG = "ng";

  private final MessageSource messageSource;

  // This is demo
  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleRuntimeException(Exception exception, WebRequest request) {

    // log
    log.error("log error is here");

    ErrorResponse response =
        ErrorResponse.builder()
            .result(RESULT_NG)
            .errorMessage(Arrays.asList("This is error 500"))
            .build();

    return super.handleExceptionInternal(
        exception, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
}