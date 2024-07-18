package Dtos;

public class ResultadoDTO {

    private String valor;

    private int practicaId; // Usamos el ID de la práctica para referenciarla
    private PracticaDTO practicaDTO;
    private int peticionId; // Usamos el ID de la petición para referenciarla
    private boolean finalizado;
    private boolean valorCritico;
    private boolean valorReservado;

    // Constructor
    public ResultadoDTO(String valor, int practicaId, int peticionId, boolean finalizado, boolean valorCritico, boolean valorReservado) {
        this.valor = valor;
        this.practicaId = practicaId;
        //this.practicaDTO = practicaDTO;
        this.peticionId = peticionId;
        this.finalizado = finalizado;
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

    public PracticaDTO getPracticaDTO() {
        return practicaDTO;
    }
    public void setPracticaDTO(PracticaDTO practicaDTO) {
        this.practicaDTO = practicaDTO;
    }

    public int getPeticionId() {
        return peticionId;
    }

    public void setPeticionId(int peticionId) {
        this.peticionId = peticionId;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
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
