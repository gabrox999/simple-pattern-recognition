package it.madlabs.patternrec.web.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Point
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-30T20:32:37.777Z")

public class Point   {

  @JsonProperty("x")
  private Double x = null;

  @JsonProperty("y")
  private Double y = null;

  public Point(){}

  public Point(Double x, Double y) {
    this.x = x;
    this.y = y;
  }

  public Point x(Double x) {
    this.x = x;
    return this;
  }

   /**
   * Get x
   * @return x
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Point y(Double y) {
    this.y = y;
    return this;
  }

   /**
   * Get y
   * @return y
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return Objects.equals(this.x, point.x) &&
        Objects.equals(this.y, point.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

