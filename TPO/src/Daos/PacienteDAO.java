package Daos;

import model.Paciente;

public class PacienteDAO extends GenericDAOImpl<Paciente, Integer> {
    private static PacienteDAO instance;

    private PacienteDAO() {
        // Constructor privado para evitar instanciación externa
    }

    public static PacienteDAO getInstance() {
        if (instance == null) {
            instance = new PacienteDAO();
        }
        return instance;
    }

    @Override
    protected Integer getId(Paciente entity) {
        return entity.getDNIPaciente();
    }

    @Override
    public Paciente findById(Integer dni) {
        return super.findById(dni);
    }
}
