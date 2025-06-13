package ar.edu.utn.frba.dds.qmp;

import lombok.Getter;

@Getter
public class Color {

  private Integer red;
  private Integer green;
  private Integer blue;

  public Color(Integer red, Integer green, Integer blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public boolean esIgual(Color otroColor) {
    return this.red.equals(otroColor.getRed())
        && this.green.equals(otroColor.getGreen())
        && this.blue.equals(otroColor.getBlue());
  }

}
