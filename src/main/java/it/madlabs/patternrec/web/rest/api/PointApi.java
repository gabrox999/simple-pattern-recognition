/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.madlabs.patternrec.web.rest.api;

import io.swagger.annotations.*;
import it.madlabs.patternrec.web.rest.controllers.common.ServerErrorException;
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

@Api(value = "", description = "the point API")
public interface PointApi {

    @ApiOperation(value = "/point", notes = "Add a point to the space POST/point  with body { \"x\": ..., \"y\": ... } ", response = Point.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "added point to the space", response = Point.class),
        @ApiResponse(code = 400, message = "bad parameters", response = ErrorModel.class),
        @ApiResponse(code = 500, message = "Unexpected Error", response = ErrorModel.class) })
    @RequestMapping(value = "/point",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addPoint(@ApiParam(value = "a point to add to the space", required = true) @Valid @RequestBody Point point);

}
