package model;

import java.util.Date;
import java.util.List;

public class Peticion {

    private int idPeticion;

    //TODO ver si va esta relacion
    private Paciente paciente;
    private String obraSocial;
    private Date fechaCarga;

    //TODO ver si hay que ponerlo
    private Date fechaCalculadaDeEntrega;
    private Sucursal sucursal;
    private List<Practica> listaPracticas;
    private List<Resultado> listaResultados;

    // Constructor
    public Peticion(int idPeticion, Paciente paciente, String obraSocial, Date fechaCarga,  Date fechaCalculadaDeEntrega, Sucursal sucursal, List<Practica> listaPracticas, List<Resultado> listaResultados) {
        this.idPeticion = idPeticion;
        this.paciente = paciente;
        this.obraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.fechaCalculadaDeEntrega = fechaCalculadaDeEntrega;
        this.sucursal = sucursal;
        this.listaPracticas = listaPracticas;
        this.listaResultados = listaResultados;
    }

    // Getters y Setters
    public int getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(int idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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


    public Date getFechaCalculadaDeEntrega() {
        return fechaCalculadaDeEntrega;
    }

    public void setFechaCalculadaDeEntrega(Date fechaCalculadaDeEntrega) {
        this.fechaCalculadaDeEntrega = fechaCalculadaDeEntrega;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Practica> getListaPracticas() {
        return listaPracticas;
    }

    public void setListaPracticas(List<Practica> listaPracticas) {
        this.listaPracticas = listaPracticas;
    }

    public List<Resultado> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<Resultado> listaResultados) {
        this.listaResultados = listaResultados;
    }

    // Método para chequear si la petición está finalizada
    //TODO si ya tiene un resultado es que la peticion esta finalizada ?? ahi te lo cambie
    //quiero chequear si la peticion esta finalizada -> cuando esta finalizada? cuando tiene

    //TODO le agregaria un atributo al resultado para saber si esta finalizado o no
    public Boolean chequearSiLaPeticionEstaFinalizada() {
        return !listaResultados.isEmpty();
    }

    // Método para chequear si tiene resultados críticos
    public boolean chequearSiTieneResultadosCriticos() {
        for (Resultado resultado : listaResultados) {
            if (resultado.isValorCritico()) {
                return true;
            }
        }
        return false;
    }

    // Método para obtener el mensaje de retiro por sucursal
    public String mostrarMensaje(int idSucursal) {
        return "Retirar por sucursal " + idSucursal;
    }

    // Método para mostrar los resultados
    public List<Resultado> mostrarResultados() {
        return listaResultados;
    }
}
