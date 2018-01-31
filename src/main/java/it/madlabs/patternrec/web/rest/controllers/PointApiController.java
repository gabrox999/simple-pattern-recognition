package it.madlabs.patternrec.web.rest.controllers;

import io.swagger.annotations.ApiParam;
import it.madlabs.patternrec.web.rest.api.PointApi;
import it.madlabs.patternrec.web.rest.model.Point;
import it.madlabs.patternrec.web.rest.service.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

@Controller
public class PointApiController implements PointApi {

    private PointService pointService;

    public PointApiController(PointService pointService) {
        this.pointService = pointService;
    }

    public ResponseEntity<Point> addPoint(@ApiParam(value = "a point to add to the space" ,required=true )  @Valid @RequestBody Point point) {
        // do some magic!
        return new ResponseEntity<Point>(pointService.addPoint(point), HttpStatus.OK);
    }

    public ResponseEntity<List<Point>> allCollinearPoints(@ApiParam(value = "number of COLLINEAR segments",required=true ) @PathVariable("n") Long n) {
        // do some magic!
        return new ResponseEntity<List<Point>>(pointService.allCollinearPoints(n), HttpStatus.OK);
    }

    public ResponseEntity<List<Point>> allPoints() {
        // do some magic!
        return new ResponseEntity<List<Point>>(pointService.allPoints(), HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteAllPoints() {
        // do some magic!
        pointService.deleteAllPoints();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
