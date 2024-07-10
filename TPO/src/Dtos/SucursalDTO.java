package Dtos;

import java.util.List;

public class SucursalDTO {
    private int numero;
    private String direccion;
    private String responsableTecnico; // Asumimos que responsableTecnico es el nombre del usuario responsable
    private List<Integer> peticionesIds; // Lista de IDs de peticiones asociadas

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

    public String getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(String responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }

    public List<Integer> getPeticionesIds() {
        return peticionesIds;
    }

    public void setPeticionesIds(List<Integer> peticionesIds) {
        this.peticionesIds = peticionesIds;
    }
}
