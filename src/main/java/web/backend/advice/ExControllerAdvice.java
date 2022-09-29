package web.backend.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.backend.exception.CustomRuntimeException;
import web.backend.response.CommonResponse;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler
    public CommonResponse<String> exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new CommonResponse(false, "시스템 오류");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public CommonResponse<String> customExHandler(CustomRuntimeException e) {
        log.error("[exceptionHandle] ex", e);
        return new CommonResponse(false, e.getMessage());
    }
}
