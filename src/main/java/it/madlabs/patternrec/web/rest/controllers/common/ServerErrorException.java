package it.madlabs.patternrec.web.rest.controllers.common;

public class ServerErrorException extends ApiException {
    public ServerErrorException(String msg) {
        super(500, msg);
        System.out.println("");
    }
}
