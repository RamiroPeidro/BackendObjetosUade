package Dtos;

import java.util.List;

public class SucursalDTO {
    private int numero;
    private String direccion;
    private UsuarioDTO responsableTecnico; // Ahora es un UsuarioDTO
    private List<Integer> peticionesIds; // Lista de IDs de peticiones asociadas

    // Constructor
    public SucursalDTO(int numero, String direccion, UsuarioDTO responsableTecnico, List<Integer> peticionesIds) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
        this.peticionesIds = peticionesIds;
    }

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

    public UsuarioDTO getResponsableTecnico() {
        return responsableTecnico;
    }

    public void setResponsableTecnico(UsuarioDTO responsableTecnico) {
        this.responsableTecnico = responsableTecnico;
    }

    public List<Integer> getPeticionesIds() {
        return peticionesIds;
    }

    public void setPeticionesIds(List<Integer> peticionesIds) {
        this.peticionesIds = peticionesIds;
    }
}
