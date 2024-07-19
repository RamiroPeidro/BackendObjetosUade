package model;

public class RangoValor {
    private float minValor;
    private float maxValor;

    // Constructor
    public RangoValor(float minValor, float maxValor) {
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


    // Método para verificar si el valor es crítico
    public boolean esCritico(float valor) {
        return valor < minValor || valor > maxValor;
    }

    // Método para verificar si el valor es reservado
}
