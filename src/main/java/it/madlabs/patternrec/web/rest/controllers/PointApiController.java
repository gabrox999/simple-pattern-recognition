package it.madlabs.patternrec.web.rest.controllers;

import io.swagger.annotations.ApiParam;
import it.madlabs.patternrec.web.rest.api.PointApi;
import it.madlabs.patternrec.web.rest.controllers.common.*;
import it.madlabs.patternrec.web.rest.model.Point;
import it.madlabs.patternrec.web.rest.service.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

@RestController
public class PointApiController extends AbstractRestController implements PointApi {

    private PointService pointService;

    public PointApiController(PointService pointService) {
        this.pointService = pointService;
    }

    public ResponseEntity<Void> addPoint(@ApiParam(value = "a point to add to the space" ,required=true )  @Valid @RequestBody Point point) {
        try {
            pointService.addPoint(point);
        } catch (IllegalArgumentException e){
            throw new BadRequestException(e.getMessage());
        }catch (Exception e){
            throw new ServerErrorException(e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
