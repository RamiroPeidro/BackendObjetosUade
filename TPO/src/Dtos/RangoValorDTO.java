package Dtos;

public class RangoValorDTO {

    private float minValor;
    private float maxValor;
    private float umbralReservado;

    // Constructor
    public RangoValorDTO(float minValor, float maxValor, float umbralReservado) {
        this.minValor = minValor;
        this.maxValor = maxValor;
        this.umbralReservado = umbralReservado;
    }

    // Getters y Setters
    public float getMinValor() {
        return minValor;
    }

    public void setMinValor(float minValor) {
        this.minValor = minValor;
    }

    public float getMaxValor() {
        return maxValor;
    }

    public void setMaxValor(float maxValor) {
        this.maxValor = maxValor;
    }

    public float getUmbralReservado() {
        return umbralReservado;
    }

    public void setUmbralReservado(float umbralReservado) {
        this.umbralReservado = umbralReservado;
    }
}
