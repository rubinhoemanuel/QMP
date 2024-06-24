package ar.edu.utn.frba.dds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class ServicioMeteorologico {

  private AccuWeatherAPI apiClima;

  public Integer getTemperatura(String ciudad) {
    List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
    Map<String, Object> mapa = (Map<String, Object>) condicionesClimaticas.get(0).get("Temperature");
    return mapa.get("Unit").equals("F")?convertirACelcius((Integer) mapa.get("Value")):(Integer) mapa.get("Value");
  }

  private Integer convertirACelcius(Integer farh) {
    return (farh-32) * 5/9;
  }

}
