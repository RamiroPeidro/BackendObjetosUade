package controller;

import Dtos.PeticionDTO;
import Dtos.PracticaDTO;
import Dtos.ResultadoDTO;
import service.PeticionService;

public class LaboratoristaController {

    private static LaboratoristaController instance = null;
    private PeticionService peticionService;

    public LaboratoristaController() {
        this.peticionService = new PeticionService();
    }

    public static LaboratoristaController getInstance() {
        if (instance == null) {
            instance = new LaboratoristaController();
        }
        return instance;
    }

    public void cargarResultado(float valor, int idPeticion, int idPractica) {
        peticionService.cargarResultadoEnPractica(idPeticion, idPractica, valor);
    }

    public void eliminarResultado(int idPeticion, int idPractica) {
        PeticionDTO peticion = getPeticionById(idPeticion);
        if (peticion != null) {
            for (ResultadoDTO resultado : peticion.getListaResultados()) {
                if (resultado.getPracticaId() == idPractica) {
                    resultado.setValor("NaN");
                    resultado.setFinalizado(false);
                    break;
                }
            }
        }
        peticionService.updatePeticion(peticion); // Asegúrate de tener un método para actualizar la petición
    }


    public void modificarResultado(int idPeticion, int idPractica, float nuevoValor, boolean finalizado) {
        peticionService.modificarResultadoDePractica(idPeticion, idPractica, nuevoValor, finalizado);
    }

    public PeticionDTO getPeticionById(int idPeticion) {
        try {
            return peticionService.getPeticionById(idPeticion);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public int getPracticaIdByName(String practicaName) {
        try {
            PracticaDTO practica = peticionService.getPracticaByName(practicaName);
            return practica != null ? practica.getCodigoPractica() : -1;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public String getPracticaNombreById(int practicaId) {
        try {
            PracticaDTO practica = peticionService.getPracticaById(practicaId);
            return practica != null ? practica.getNombrePractica() : null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Float getResultadoDePractica(int idPeticion, int idPractica) {
        return peticionService.getResultadoDePractica(idPeticion, idPractica);
    }
}
