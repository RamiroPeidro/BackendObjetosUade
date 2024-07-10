package Daos;

import model.Paciente;

public class PacienteDAO extends GenericDAOImpl<Paciente, Integer> {

    @Override
    protected Integer getId(Paciente entity) {
        return entity.getDNIPaciente();
    }

    @Override
    public Paciente findById(Integer dni) {
        for (Paciente paciente : findAll()) {
            if (paciente.getDNIPaciente() == dni) {
                return paciente;
            }
        }
        return null;
    }
}
