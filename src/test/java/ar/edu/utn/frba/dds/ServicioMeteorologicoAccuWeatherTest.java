package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Test;

public class ServicioMeteorologicoAccuWeatherTest {

  private ServicioMeteorologicoAccuWeather servicioMeteorologico;

  @Test
  public void obtenerTemperaturaDeUnaCiudad() {
    this.servicioMeteorologico = new ServicioMeteorologicoAccuWeather(new AccuWeatherAPI());
    var temp = this.servicioMeteorologico.getTemperatura("Buenos Aires, Argentina");
    System.out.println(temp);
  }

}
