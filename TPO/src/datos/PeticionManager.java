package datos;

import Dtos.PeticionDTO;
import model.Peticion;
import model.Resultado;
import model.Sucursal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionManager {
    private static Date fechaInicio;
    private static Date fechaFin;

    private static List<Peticion> harcodedPeticiones = new ArrayList<>();


    static {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaInicio = sdf.parse("28/05/2024");
            Date fechaFin = sdf.parse("01/06/2024");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Peticion peticion1 = new Peticion(1, PacienteManager.buscarPorDni(37845123), "Osde", fechaInicio, fechaFin, new Sucursal(), PracticaManager.getHarcodedPracticas());
        Peticion peticion2 = new Peticion(2, PacienteManager.buscarPorDni(38845123), "Swiss Medical", fechaInicio, fechaFin, new Sucursal(), PracticaManager.getHarcodedPracticas());
        harcodedPeticiones.add(peticion1);
        harcodedPeticiones.add(peticion2);

    }

    public static Peticion getPeticionById(int id) {
        for (Peticion peticion : harcodedPeticiones) {
            if (peticion.getIdPeticion() == id) {
                return peticion;
            }
        }
        return null;
    }

    public static List<Resultado> getListaResultadosPeticion(int idPeticion){
        for(Peticion peticion : harcodedPeticiones){
            if (peticion.getIdPeticion() == idPeticion) {
                return ResultadoManager.getResultadosPeticion(idPeticion);
            }
        }
        return null;
    }


    //LISTAR PETICIONES CRITICAS
    public List<Peticion> listarPeticionesCriticas() {
        setearResultadosASusPeticiones();
        List<Peticion> peticiones = harcodedPeticiones;
        List<Peticion> peticionesCriticas = new ArrayList<>();

        for (Peticion peticion : peticiones) {
            if (peticion.chequearSiTieneResultadosCriticos()) {
                peticionesCriticas.add(peticion);
            }
        }
        return peticionesCriticas;
    }

    public List<Peticion> getHarcodedPeticiones() {
        return harcodedPeticiones;
    }

    public static void setearResultadosASusPeticiones() {
        for (Peticion peticion : harcodedPeticiones) {
            List<Resultado> resultados = new ArrayList<>();
            for (Resultado resultado : ResultadoManager.getHarcodedResultados()) {
                if (resultado.getPeticion().getIdPeticion() == peticion.getIdPeticion()) {
                    resultados.add(resultado);
                }
            }
            peticion.setListaResultados(resultados);
        }
    }


}