package model;

public class RangoValor {
    private float minValor;
    private float maxValor;
    private float umbralReservado; // Define cuánto más allá del maxValor es considerado reservado

    // Constructor
    public RangoValor(float minValor, float maxValor, float umbralReservado) {
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

    // Método para verificar si el valor es crítico
    public boolean esCritico(float valor) {
        return valor < minValor || valor > maxValor;
    }

    // Método para verificar si el valor es reservado
    public boolean esReservado(float valor) {
        return valor > maxValor + umbralReservado || valor < minValor - umbralReservado;
    }
}
