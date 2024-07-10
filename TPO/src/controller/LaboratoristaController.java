package controller;

import service.PeticionService;
import model.Practica;

public class LaboratoristaController {

    private PeticionService peticionService;

    public LaboratoristaController() {
        this.peticionService = new PeticionService();
    }


    public void cargarResultado(float valor, int idPeticion, int idPractica) {
        peticionService.cargarResultadoEnPractica(idPeticion, idPractica, valor);
    }

    public void eliminarResultado(int idResultado) {
        // Implementar lógica para eliminar resultado si es necesario
    }
}
