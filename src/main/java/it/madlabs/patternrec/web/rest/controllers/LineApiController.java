package it.madlabs.patternrec.web.rest.controllers;

import io.swagger.annotations.ApiParam;
import it.madlabs.patternrec.web.rest.api.LineApi;
import it.madlabs.patternrec.web.rest.api.PointApi;
import it.madlabs.patternrec.web.rest.controllers.common.AbstractRestController;
import it.madlabs.patternrec.web.rest.controllers.common.BadRequestException;
import it.madlabs.patternrec.web.rest.controllers.common.ServerErrorException;
import it.madlabs.patternrec.web.rest.model.Point;
import it.madlabs.patternrec.web.rest.service.PointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

@RestController
public class LineApiController extends AbstractRestController implements LineApi {

    private PointService pointService;

    public LineApiController(PointService pointService) {
        this.pointService = pointService;
    }

    public ResponseEntity<List<List<Point>>> allCollinearPoints(@ApiParam(value = "number of COLLINEAR segments",required=true ) @PathVariable("n") Integer n) {
        try {
            return new ResponseEntity<List<List<Point>>>(pointService.allCollinearPoints(n), HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new BadRequestException(e.getMessage());
        }catch (Exception e) {
            throw new ServerErrorException(e.getMessage());
        }
    }

}
