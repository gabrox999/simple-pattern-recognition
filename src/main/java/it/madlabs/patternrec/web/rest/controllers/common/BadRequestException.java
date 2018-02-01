package it.madlabs.patternrec.web.rest.controllers.common;

public class BadRequestException extends ApiException {
    public BadRequestException(String msg) {
        super(400, msg);
    }
}
