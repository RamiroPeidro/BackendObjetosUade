package Dtos;

public class RangoValorDTO {

    private float minValor;
    private float maxValor;

    // Constructor
    public RangoValorDTO(float minValor, float maxValor) {
        this.minValor = minValor;
        this.maxValor = maxValor;
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

}
