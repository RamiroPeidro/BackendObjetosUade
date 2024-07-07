package model;

import java.util.Date;
import java.util.List;

public class Peticion {

    private int idPeticion;
    private Paciente paciente;
    private String obraSocial;
    private Date fechaCarga;
    private Practica practicaAsociada;
    private Date fechaCalculadaDeEntrega; //TODO: Renombrar.
    private Sucursal sucursal;
    private List<Practica> listaPracticas;
    private List<Resultado> listaResultados;

    //TODO: Hace falta agregar los get explicitamente si solo devuelven el valor? cambiar.

    public void getEstadoPeticion() {
    } //TODO: Tenemos un atributo que sea estado? como lo sacamos?

    public void getFinalizado() {
    } //TODO: Resultado finalizado o peticion finalizada??

    public void getPeticionAsociada(int numeroSucursal) {
    }

    public void setSucursal() {
    }//TODO: Esto tiene como parametro sucursalDestinoPeticiones, que tipo es?

    public void getResultados(int idPeticion) {
    }

    public String mostrarMensaje(int idSucursal) { //TODO: Agregar idSucursal al diagrama de clases.
        return "Retirar por sucursal " + idSucursal;
    }

    public List<Resultado> mostrarResultados(List<Resultado> resultados) { //TODO: Agregar List<Resultado> al diagrama de clases.
        return resultados;
    }

    public void listarPeticion(int idPeticion) {
    } //TODO: que tiene que devolver esto?

    public void getPeticionesCriticas() {
    } //TODO: Revisar.

    public void chequearSiTieneResultadosCriticos() { //TODO: Deberia devolver un boolean
        // TODO: o una lista de resultados criticos? aclarar en el diagrama.
    }

    public void getPracticaAsociada() { //TODO: Revisar.
    }

    public void newPeticion() { //TODO: newPeticion esta duplicado, hay que eliminarlo?
    }

    public void newPeticion(Paciente paciente, String obraSocial, Practica practica, Sucursal sucursal) {
    }

    public void getIdPeticion() {
    }

    public void getListaResultados() {
    } //TODO: Esta duplicado en el diagrama de clases, eliminarlo.

    public void chequearSiLaPeticionEstaFinalizada() {
    }

    public void getSucursal() {
    }
}
