package Daos;

import model.Practica;

import java.util.ArrayList;
import java.util.List;

public class PracticaDAO extends GenericDAOImpl<Practica, Integer> {
    private static PracticaDAO instance;
    private List<Practica> practicas;

    private PracticaDAO() {
        this.practicas = new ArrayList<>();
    }

    public static PracticaDAO getInstance() {
        if (instance == null) {
            instance = new PracticaDAO();
        }
        return instance;
    }

    @Override
    public Practica findById(Integer id) {
        for (Practica practica : practicas) {
            if (practica.getCodigoPractica() == id) {
                return practica;
            }
        }
        return null;
    }

    @Override
    public List<Practica> findAll() {
        return new ArrayList<>(practicas);
    }

    @Override
    public void create(Practica practica) {
        practicas.add(practica);
    }

    @Override
    public void update(Practica practica) {
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
