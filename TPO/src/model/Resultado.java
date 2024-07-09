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
        for (RangoValor rango : practica.getRangoValores()) {
            if (rango.esCritico(this.valor)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar si el resultado tiene valores reservados
    private boolean verificarValorReservado() {
        for (RangoValor rango : practica.getRangoValores()) {
            if (rango.esReservado(this.valor)) {
                return true;
            }
        }
        return false;
    }
}
