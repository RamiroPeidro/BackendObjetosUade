package Daos;

import java.util.ArrayList;
import java.util.List;

public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    private List<T> entities = new ArrayList<>();

    @Override
    public void create(T entity) {
        entities.add(entity);
    }

    @Override
    public T findById(ID id) {
        for (T entity : entities) {
            if (getId(entity).equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void update(T entity) {
        for (int i = 0; i < entities.size(); i++) {
            if (getId(entities.get(i)).equals(getId(entity))) {
                entities.set(i, entity);
                return;
            }
        }
    }

    @Override
    public void delete(T entity) {
        entities.remove(entity);
    }

    // Este método debe ser implementado por las subclases para obtener la ID de la entidad
    protected ID getId(T entity) {
        throw new UnsupportedOperationException("Debe ser implementado por la subclase");
    }
}
