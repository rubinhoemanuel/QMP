package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Test;

public class ServicioMeteorologicoTest {

  private ServicioMeteorologico servicioMeteorologico;

  @Test
  public void obtenerTemperaturaDeUnaCiudad() {
    this.servicioMeteorologico = new ServicioMeteorologico(new AccuWeatherAPI());
    var temp = this.servicioMeteorologico.getTemperatura("Buenos Aires, Argentina");
    System.out.println(temp);
  }

}
