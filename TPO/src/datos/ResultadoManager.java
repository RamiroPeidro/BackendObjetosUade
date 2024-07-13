package datos;

import model.Peticion;
import model.Practica;
import model.Resultado;

import java.util.ArrayList;
import java.util.List;

public class ResultadoManager {

    private static List<Resultado> harcodedResultados = new ArrayList<>();
    private static List<Resultado> resultadosPeticion = new ArrayList<>();


    static {
        Resultado resultado1 = new Resultado(80, PracticaManager.getPracticaByName("Hemograma Completo"), PeticionManager.getPeticionById(1));
        Resultado resultado2 = new Resultado(1245, PracticaManager.getPracticaByName("Perfil Lipídico"), PeticionManager.getPeticionById(1));
        Resultado resultado3 = new Resultado(503, PracticaManager.getPracticaByName("Protrombina"), PeticionManager.getPeticionById(1));
        Resultado resultado4 = new Resultado(22, PracticaManager.getPracticaByName("Panel de Hormonas Tiroideas"), PeticionManager.getPeticionById(2));
        Resultado resultado5 = new Resultado(11, PracticaManager.getPracticaByName("Electrolitos Sanguíneos"), PeticionManager.getPeticionById(2));
        Resultado resultado6 = new Resultado(462, PracticaManager.getPracticaByName("Prueba de Tolerancia a la Glucosa"), PeticionManager.getPeticionById(2));


        harcodedResultados.add(resultado1);
        harcodedResultados.add(resultado2);
        harcodedResultados.add(resultado3);
        harcodedResultados.add(resultado4);
        harcodedResultados.add(resultado5);
        harcodedResultados.add(resultado6);

    }

    public static List<Resultado> getHarcodedResultados() {
        return harcodedResultados;
    }

    public static List<Resultado> getResultadosPeticion(int idPeticion) {
        for (Resultado resultado : harcodedResultados) {
            if (resultado.getPeticion().getIdPeticion() == idPeticion) {
                resultadosPeticion.add(resultado);
            }
            PeticionManager.getPeticionById(idPeticion).setListaResultados(resultadosPeticion);
        }
        return PeticionManager.getPeticionById(idPeticion).getListaResultados();
    }

    /*public static void setearResultadosASusPeticiones() {
        for (Peticion peticion : )
            for (Resultado resultado : harcodedResultados) {


            }

    }*/
}