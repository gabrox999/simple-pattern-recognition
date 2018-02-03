# simple-pattern-recognition

Little exercize solving this problem:
Given a set of P feature points in the bidimensional plane, determine every line that contains at least N or
more COLLINEAR points.

Added API exposing this functionalities:

POST /point with body { "x": ..., "y": ... }
Add a point to the space

GET /space
Get all points in the space

GET /lines/{n}
Get all line segments passing through at least N points. Note that a line segment should be a set of
COLLINEAR points.

DELETE /space
Remove all points from the space

## Launching application

    ./mvnw
    
go to http://localhost:8080 to see the running application 

## Testing

To launch your application's tests, run:

    ./mvnw clean test
