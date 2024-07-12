package datos;
import model.Email;
import model.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteManager {

    private static List<Paciente> harcodedPacientes = new ArrayList<>();

    static {
        Paciente paciente1 = new Paciente("Juan", 37845123, "Corrientes 5620", new Email("juan.perez@example.com"), "masculino", 30);
        Paciente paciente2 = new Paciente("Maria", 41234567, "Lavalle 1150", new Email("maria.lopez@example.com"), "femenino", 28);
        Paciente paciente3 = new Paciente("Luis", 40123456, "Sarmiento 220", new Email("luis.gomez@example.com"), "masculino", 32);
        Paciente paciente4 = new Paciente("Ana", 42345678, "Rivadavia 4500", new Email("ana.fernandez@example.com"), "femenino", 26);

        harcodedPacientes.add(paciente1);
        harcodedPacientes.add(paciente2);
        harcodedPacientes.add(paciente3);
        harcodedPacientes.add(paciente4);
    }

    public static List<Paciente> getHarcordedPacientes() {
        return harcodedPacientes;
    }
}

