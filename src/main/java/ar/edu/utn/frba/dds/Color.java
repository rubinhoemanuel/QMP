package ar.edu.utn.frba.dds;

import java.math.BigDecimal;

public class Color {

  private BigDecimal red;
  private BigDecimal green;
  private BigDecimal blue;

  public Color(BigDecimal red, BigDecimal green, BigDecimal blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public BigDecimal getRed() {
    return red;
  }

  public BigDecimal getGreen() {
    return green;
  }

  public BigDecimal getBlue() {
    return blue;
  }

}
