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

    public void eliminarResultado(int idPeticion, int idPractica) {
        peticionService.eliminarResultadoDePractica(idPeticion, idPractica);
    }

    public void modificarResultado(int idPeticion, int idPractica, float nuevoValor, boolean finalizado) {
        peticionService.modificarResultadoDePractica(idPeticion, idPractica, nuevoValor, finalizado);
    }
}
