package Dtos;

public class PracticaDTO {

    private int codigoPractica;
    private String nombrePractica;
    private String grupo;
    private RangoValorDTO rangoValores;
    private Float cantHorasResultados;
    private Boolean habilitada;

    // Constructor
    public PracticaDTO(int codigoPractica, String nombrePractica, String grupo, RangoValorDTO rangoValores, Float cantHorasResultados, Boolean habilitada) {
        this.codigoPractica = codigoPractica;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.rangoValores = rangoValores;
        this.cantHorasResultados = cantHorasResultados;
        this.habilitada = habilitada;
    }

    // Getters y Setters
    public int getCodigoPractica() {
        return codigoPractica;
    }

    public void setCodigoPractica(int codigoPractica) {
        this.codigoPractica = codigoPractica;
    }

    public String getNombrePractica() {
        return nombrePractica;
    }

    public void setNombrePractica(String nombrePractica) {
        this.nombrePractica = nombrePractica;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public RangoValorDTO getRangoValores() {
        return rangoValores;
    }

    public void setRangoValores(RangoValorDTO rangoValores) {
        this.rangoValores = rangoValores;
    }

    public Float getCantHorasResultados() {
        return cantHorasResultados;
    }

    public void setCantHorasResultados(Float cantHorasResultados) {
        this.cantHorasResultados = cantHorasResultados;
    }

    public Boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(Boolean habilitada) {
        this.habilitada = habilitada;
    }
}
