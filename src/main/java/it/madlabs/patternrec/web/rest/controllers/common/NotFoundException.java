package it.madlabs.patternrec.web.rest.controllers.common;

import it.madlabs.patternrec.web.rest.controllers.common.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends ApiException {
    public NotFoundException (String msg) {
        super(404, msg);
    }
}
