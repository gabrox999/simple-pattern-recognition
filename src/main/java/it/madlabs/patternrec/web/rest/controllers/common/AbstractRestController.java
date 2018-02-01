package it.madlabs.patternrec.web.rest.controllers.common;

import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AbstractRestController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiResponseMessage exception(NotFoundException e) {
        return new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ApiResponseMessage exception(BadRequestException e) {
        return new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerErrorException.class)
    public ApiResponseMessage exception(ServerErrorException e) {
        return new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage());
    }
}