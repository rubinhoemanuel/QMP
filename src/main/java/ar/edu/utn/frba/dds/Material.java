package ar.edu.utn.frba.dds;

public class Material {

    private TipoMaterial tipo;
    private Trama trama;

    public Material(TipoMaterial tipo, Trama trama) {
        this.tipo = tipo;
        this.trama = trama;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

}
