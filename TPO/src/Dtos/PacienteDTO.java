package Dtos;

import java.util.List;

public class PacienteDTO {
    private String nombre;
    private int dni;
    private String domicilio;
    private String mail;
    private String sexo;
    private int edad;
    private List<Integer> peticionesIds; // Lista de IDs de peticiones asociadas

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Integer> getPeticionesIds() {
        return peticionesIds;
    }

    public void setPeticionesIds(List<Integer> peticionesIds) {
        this.peticionesIds = peticionesIds;
    }
}
