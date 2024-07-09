package model;

public class Resultado {

    private float valor;
    private Practica practica;
    private boolean valorCritico;
    private boolean valorReservado;

    // Constructor
    public Resultado(float valor, Practica practica) {
        this.valor = valor;
        this.practica = practica;
        this.valorCritico = verificarValorCritico();
        this.valorReservado = verificarValorReservado();
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
        RangoValor rango = practica.getRangoValores();
        return rango.esReservado(this.valor);
    }
}
