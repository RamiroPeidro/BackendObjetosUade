package Daos;

import model.Practica;

import java.util.ArrayList;
import java.util.List;

public class PracticaDAO extends GenericDAOImpl<Practica, Integer> {

    private List<Practica> practicas = new ArrayList<>();

    @Override
    public Practica findById(Integer id) {
        // Implementación de búsqueda por ID si es necesario
        // Para este ejemplo, asumimos que ID es el índice de la lista
        for (Practica practica : practicas) {
            if (practica.getCodigoPractica() == id) {
                return practica;
            }
        }
        return null;
    }

    @Override
    public List<Practica> findAll() {
        return practicas;
    }

    @Override
    public void create(Practica practica) {
        practicas.add(practica);
    }

    @Override
    public void update(Practica practica) {
        // Implementación de actualización si es necesario
        // Para este ejemplo, asumimos que ID es el índice de la lista
        int index = -1;
        for (int i = 0; i < practicas.size(); i++) {
            if (practicas.get(i).getCodigoPractica() == practica.getCodigoPractica()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            practicas.set(index, practica);
        }
    }

    @Override
    public void delete(Practica practica) {
        practicas.remove(practica);
    }
}
