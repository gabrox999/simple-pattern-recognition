/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.madlabs.patternrec.web.rest.api;

import io.swagger.annotations.*;
import it.madlabs.patternrec.web.rest.model.ErrorModel;
import it.madlabs.patternrec.web.rest.model.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

@Api(value = "point", description = "the point API")
public interface PointApi {

    @ApiOperation(value = "", notes = "Add a point to the space POST/point  with body { \"x\": ..., \"y\": ... } ", response = Point.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "added point", response = Point.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/point",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Point> addPoint(@ApiParam(value = "a point to add to the space", required = true) @Valid @RequestBody Point point);


    @ApiOperation(value = "", notes = "Get all line segments passing through at least  N points. Note that a line segment should be a  set of COLLINEAR points.  GET /lines/{n}  Example Request: GET /lines/2   [     [       {\"x\": 2, \"y\": 3},       {\"x\": -2, \"y\": 1023}     ],     [       {\"x\": 3.2, \"y\": 0},       {\"x\": -2, \"y\": 1023}     ],   ...   ] ", response = Point.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "set of COLLINEAR points", response = Point.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/point/lines/{n}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Point>> allCollinearPoints(@ApiParam(value = "number of COLLINEAR segments", required = true) @PathVariable("n") Long n);


    @ApiOperation(value = "", notes = "Get all points in the space  GET /space  Example response [   {\"x\": 2, \"y\": 3},   {\"x\": -2, \"y\": 1023},   {\"x\": 3.2, \"y\": 0}, ... ] ", response = Point.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "all points present in the space", response = Point.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/point",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Point>> allPoints();


    @ApiOperation(value = "", notes = "Remove all points from the space DELETE /space ", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "all points deleted", response = Void.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/point",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAllPoints();

}
