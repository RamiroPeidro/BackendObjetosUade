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


    //sucursal se puede dar de baja? ---> recorro todas las peticiones que tiene la sucursal ->> recorro todos los resultados de cada peticio menor
    //Digamos, sucursal A tiene -> m peticiones -> recorro todos los resultados n.
    //Cada vez que quiero bajar una sucursal tengo un O(n x m)

    //peticiones puede ser infinito, resultados es finito, por eso en terminos practiso es O(m x n) pero con 0 <= n <= K, con K finito, a terminos practicos max 50?

    //a casos practicos como sabesmos

    //Tenes un atributo en la peticion que sea, finalizada o no, te ahorras recorrer todos sus resultados.
    //O(n) -> O(n) --> MUCHO MEJOR


    public boolean chequearSiSePuedeDarDeBajaSucursal() {
        for (Peticion peticion : peticionesDeSucursal) {
            if (!peticion.isPeticionFinalizada()) {
                return false;
            }
        }
        return true;
    }
}
