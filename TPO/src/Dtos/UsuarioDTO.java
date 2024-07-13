package Dtos;

import java.util.Date;

public class UsuarioDTO {

    private String nombreUsuario;
    private String mail; // Usamos String para facilitar la transferencia de datos
    private String password;
    private String nombre;
    private String domicilio;
    private int dni;
    private Date fechaNacimiento;

    // Constructor
    public UsuarioDTO(String nombreUsuario, String mail, String password, String nombre, String domicilio, int dni, Date fechaNacimiento) {
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
