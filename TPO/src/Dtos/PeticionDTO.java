package Dtos;

import java.util.Date;
import java.util.List;

public class PeticionDTO {
    private int idPeticion;
    private int pacienteId; // Solo almacenamos el ID del paciente
    private String obraSocial;
    private Date fechaCarga;
    private int practicaAsociadaId; // Solo almacenamos el ID de la práctica
    private Date fechaCalculadaDeEntrega;
    private int sucursalId; // Solo almacenamos el ID de la sucursal
    private List<Integer> listaPracticasIds; // Lista de IDs de prácticas
    private List<ResultadoDTO> listaResultados;

    // Getters y Setters
    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public int getPracticaAsociadaId() {
        return practicaAsociadaId;
    }

    public void setPracticaAsociadaId(int practicaAsociadaId) {
        this.practicaAsociadaId = practicaAsociadaId;
    }

    public Date getFechaCalculadaDeEntrega() {
        return fechaCalculadaDeEntrega;
    }

    public void setFechaCalculadaDeEntrega(Date fechaCalculadaDeEntrega) {
        this.fechaCalculadaDeEntrega = fechaCalculadaDeEntrega;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public List<Integer> getListaPracticasIds() {
        return listaPracticasIds;
    }

    public void setListaPracticasIds(List<Integer> listaPracticasIds) {
        this.listaPracticasIds = listaPracticasIds;
    }

    public List<ResultadoDTO> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<ResultadoDTO> listaResultadosIds) {
        this.listaResultados = listaResultadosIds;
    }
}
