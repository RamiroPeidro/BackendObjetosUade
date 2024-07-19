package Daos;

import model.Resultado;

import java.util.ArrayList;
import java.util.List;

public class ResultadoDAO extends GenericDAOImpl<Resultado, Integer> {
    private static ResultadoDAO instance;
    private List<Resultado> resultados;

    private ResultadoDAO() {
        this.resultados = new ArrayList<>();
    }

    public static ResultadoDAO getInstance() {
        if (instance == null) {
            instance = new ResultadoDAO();
        }
        return instance;
    }

    @Override
    public Resultado findById(Integer id) {
        // Implementación de búsqueda por ID si es necesario
        // Para este ejemplo, asumimos que ID es el índice de la lista
        return resultados.get(id);
    }

    @Override
    public List<Resultado> findAll() {
        return new ArrayList<>(resultados);
    }

    @Override
    public void create(Resultado resultado) {
        resultados.add(resultado);
    }

    @Override
    public void update(Resultado resultado) {
        // Implementación de actualización si es necesario
        // Para este ejemplo, asumimos que ID es el índice de la lista
        int index = resultados.indexOf(resultado);
        if (index != -1) {
            resultados.set(index, resultado);
        }
    }

    @Override
    public void delete(Resultado resultado) {
        resultados.remove(resultado);
    }
}
