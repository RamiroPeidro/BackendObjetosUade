package model;

public class Resultado {

    private float valor;
    private Practica practica;
    private Peticion peticion;
    private boolean finalizado;
    private boolean valorCritico;
    private boolean valorReservado;

    // Constructor
    public Resultado(float valor, Practica practica, Peticion peticion) {
        this.valor = valor;
        this.practica = practica;
        this.finalizado = false;
        this.valorCritico = verificarValorCritico();
        this.valorReservado = verificarValorReservado();
        this.peticion = peticion;
    }

    // Getters y Setters
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
        this.valorCritico = verificarValorCritico();
        this.valorReservado = verificarValorReservado();
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public boolean isValorCritico() {
        return valorCritico;
    }

    public boolean isValorReservado() {
        return valorReservado;
    }

    // Método para verificar si el resultado tiene valores críticos
    private boolean verificarValorCritico() {
        RangoValor rango = practica.getRangoValores();
        return rango.esCritico(this.valor);
    }

    // Método para verificar si el resultado tiene valores reservados
    private boolean verificarValorReservado() {
        return this.practica.getEsReservada();
    }
}
