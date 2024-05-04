package ar.edu.utn.frba.dds;

public class ServiceLocator {

  private static ServiceLocator instance;

  private MotorDeSugerencias motorDeSugerencias;

  public static ServiceLocator getInstance() {
    if (instance == null) {
      instance = new ServiceLocator();
    }
    return instance;
  }

  public MotorDeSugerencias getMotorDeSugerencias() {
    return motorDeSugerencias;
  }

  public void setMotorDeSugerencias(MotorDeSugerencias motorDeSugerencias) {
    this.motorDeSugerencias = motorDeSugerencias;
  }

}
