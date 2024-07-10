package model;

import java.util.List;

public class Sucursal {
    private int numero;
    private String direccion;

    //TODO agregar la relacion en el diagrama
    private Usuario responsableTecnico;
    private List<Peticion> peticionesDeSucursal;

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(Usuario responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }

    public List<Peticion> getPeticionesDeSucursal() {
        return peticionesDeSucursal;
    }

    public void setPeticionesDeSucursal(List<Peticion> peticionesDeSucursal) {
        this.peticionesDeSucursal = peticionesDeSucursal;
    }

    // Método para verificar si se puede dar de baja la sucursal
    //TODO agregalo en el diagrama

    //sucursal no puede ser eliminada si tiene una peticion con resultados.


    //creo una peticiion -> le creo ya de base todos los resultados en false -> por que? porque despues puedo chequear cuales estan finalizados y cuales no.
    public boolean chequearSiSePuedeDarDeBajaSucursal() {
        for (Peticion peticion : peticionesDeSucursal) {
            if (!peticion.chequearSiLaPeticionEstaFinalizada()) {
                return false;
            }
        }
        return true;
    }
}
