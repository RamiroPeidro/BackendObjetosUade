package Dtos;

public class ResultadoDTO {

    private String valor;
    private int practicaId; // Usamos el ID de la práctica para referenciarla
    private boolean valorCritico;
    private boolean valorReservado;

    // Constructor
    public ResultadoDTO(String valor, int practicaId, boolean valorCritico, boolean valorReservado) {
        this.valor = valor;
        this.practicaId = practicaId;
        this.valorCritico = valorCritico;
        this.valorReservado = valorReservado;
    }

    // Getters y Setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPracticaId() {
        return practicaId;
    }

    public void setPracticaId(int practicaId) {
        this.practicaId = practicaId;
    }

    public boolean isValorCritico() {
        return valorCritico;
    }

    public void setValorCritico(boolean valorCritico) {
        this.valorCritico = valorCritico;
    }

    public boolean isValorReservado() {
        return valorReservado;
    }

    public void setValorReservado(boolean valorReservado) {
        this.valorReservado = valorReservado;
    }
}
