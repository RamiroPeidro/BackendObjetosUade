package Daos;

import model.Peticion;

import java.util.ArrayList;
import java.util.List;

public class PeticionDAO extends GenericDAOImpl<Peticion, Integer> {

    private List<Peticion> peticiones = new ArrayList<>();

    @Override
    public Peticion findById(Integer id) {
        for (Peticion peticion : peticiones) {
            if (peticion.getIdPeticion() == id) {
                return peticion;
            }
        }
        return null;
    }

    @Override
    public List<Peticion> findAll() {
        return peticiones;
    }

    @Override
    public void create(Peticion peticion) {
        peticiones.add(peticion);
    }

    @Override
    public void update(Peticion peticion) {
        Peticion existingPeticion = findById(peticion.getIdPeticion());
        if (existingPeticion != null) {
            int index = peticiones.indexOf(existingPeticion);
            peticiones.set(index, peticion);
        }
    }

    @Override
    public void delete(Peticion peticion) {
        peticiones.remove(peticion);
    }

    public int getLastInsertId() {
        if (peticiones.isEmpty()) {
            return 0;
        }
        return peticiones.get(peticiones.size() - 1).getIdPeticion();
    }
}
