package Dtos;

public class ResultadoDTO {

    private String valor;
    private int practicaId;
    private String nombrePractica;
    private String rangoValores;
    private int peticionId;
    private boolean finalizado;
    private boolean valorCritico;
    private boolean valorReservado;

    // Nuevos atributos relacionados con el paciente
    private String nombrePaciente;
    private String domicilioPaciente;
    private String mailPaciente;
    private String sexoPaciente;
    private int edadPaciente;

    // Constructor
    public ResultadoDTO(String valor, int practicaId, String nombrePractica, String rangoValores, int idPeticion, boolean finalizado, boolean valorCritico, boolean valorReservado, String nombrePaciente, String domicilioPaciente, String mailPaciente, String sexoPaciente, int edadPaciente) {
        this.valor = valor;
        this.practicaId = practicaId;
        this.nombrePractica = nombrePractica;
        this.rangoValores = rangoValores;
        this.peticionId = idPeticion;
        this.finalizado = finalizado;
        this.valorCritico = valorCritico;
        this.valorReservado = valorReservado;
        this.nombrePaciente = nombrePaciente;
        this.domicilioPaciente = domicilioPaciente;
        this.mailPaciente = mailPaciente;
        this.sexoPaciente = sexoPaciente;
        this.edadPaciente = edadPaciente;
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

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getRangoValores() {
        return rangoValores;
    }

    public void setRangoValores(String rangoValores) {
        this.rangoValores = rangoValores;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getDomicilioPaciente() {
        return domicilioPaciente;
    }

    public void setDomicilioPaciente(String domicilioPaciente) {
        this.domicilioPaciente = domicilioPaciente;
    }

    public String getMailPaciente() {
        return mailPaciente;
    }

    public void setMailPaciente(String mailPaciente) {
        this.mailPaciente = mailPaciente;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }
    public void setValorReservado(boolean valorReservado) {
        this.valorReservado = valorReservado;
    }
}
