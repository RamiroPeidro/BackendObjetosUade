package model;

import Dtos.ResultadoDTO;

import java.util.List;

public class Practica {

    private int codigoPractica;
    private String nombrePractica;
    private String grupo;
    private RangoValor rangoValores;
    private Float cantHorasResultados;
    private Boolean habilitada;
    private Resultado resultado;

    // Constructor
    public Practica(int codigoPractica, String nombrePractica, String grupo, RangoValor rangoValores, Float cantHorasResultados, Boolean habilitada) {
        this.codigoPractica = codigoPractica;
        this.nombrePractica = nombrePractica;
        this.grupo = grupo;
        this.rangoValores = rangoValores;
        this.cantHorasResultados = cantHorasResultados;
        this.habilitada = habilitada;
        this.resultado = null;
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

    public RangoValor getRangoValores() {
        return rangoValores;
    }

    public void setRangoValores(RangoValor rangoValores) {
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

    public Resultado getResultado() {
        return resultado;
    }
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
