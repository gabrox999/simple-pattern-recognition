package it.madlabs.patternrec.web.rest.controllers;

import io.swagger.annotations.ApiParam;
import it.madlabs.patternrec.web.rest.api.PointApi;
import it.madlabs.patternrec.web.rest.api.SpaceApi;
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
public class SpaceApiController extends AbstractRestController implements SpaceApi {

    private PointService pointService;

    public SpaceApiController(PointService pointService) {
        this.pointService = pointService;
    }

    public ResponseEntity<List<Point>> allPoints() throws ServerErrorException {
        try {
            List<Point> allPoints = pointService.allPoints();
            return new ResponseEntity<List<Point>>(allPoints, HttpStatus.OK);
        }catch (Exception e) {
            throw new ServerErrorException(e.getMessage());
        }
    }

    public ResponseEntity<Void> deleteAllPoints() {
        try {
            pointService.deleteAllPoints();
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e) {
            throw new ServerErrorException(e.getMessage());
        }

    }

}
