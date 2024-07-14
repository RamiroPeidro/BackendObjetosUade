package Daos;

import model.Peticion;

import java.util.ArrayList;
import java.util.List;

public class PeticionDAO extends GenericDAOImpl<Peticion, Integer> {

    private static PeticionDAO instance;
    private List<Peticion> peticiones;

    private PeticionDAO() {
        this.peticiones = new ArrayList<>();
    }

    public static PeticionDAO getInstance() {
        if (instance == null) {
            instance = new PeticionDAO();
        }
        return instance;
    }

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
        return new ArrayList<>(peticiones);
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
