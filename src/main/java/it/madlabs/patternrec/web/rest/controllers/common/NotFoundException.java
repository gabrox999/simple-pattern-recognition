package it.madlabs.patternrec.web.rest.controllers.common;

import it.madlabs.patternrec.web.rest.controllers.common.ApiException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
