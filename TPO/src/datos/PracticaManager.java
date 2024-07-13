package datos;

import model.Practica;
import model.RangoValor;
import java.util.ArrayList;
import java.util.List;

public class PracticaManager {
    private static List<Practica> harcodedPracticas = new ArrayList<>();

    static {
        RangoValor rango1 = new RangoValor(5, 10);
        RangoValor rango2 = new RangoValor(20, 40);
        RangoValor rango3 = new RangoValor(300, 600);
        RangoValor rango4 = new RangoValor(1100, 2200);
        RangoValor rango5 = new RangoValor(15, 30);
        RangoValor rango6 = new RangoValor(5, 20);

        Practica practica1 = new Practica(1, "Hemograma Completo", "Hematología", rango1, 24.0f, true,false);
        Practica practica2 = new Practica(2, "Perfil Lipídico", "Química Clínica", rango2, 48.0f, true,false);
        Practica practica3 = new Practica(3, "Protrombina", "Coagulación", rango3, 60.0f, true,true);
        Practica practica4 = new Practica(4, "Panel de Hormonas Tiroideas", "Endocrinología", rango4, 80.0f, true,false);
        Practica practica5 = new Practica(1, "Electrolitos Sanguíneos", "Química Clínica", rango5, 55.5f, false, true);
        Practica practica6 = new Practica(2, "Prueba de Tolerancia a la Glucosa", "Endocrinología", rango6, 75.0f, true, false);

        harcodedPracticas.add(practica1);
        harcodedPracticas.add(practica2);
        harcodedPracticas.add(practica3);
        harcodedPracticas.add(practica4);
        harcodedPracticas.add(practica5);
        harcodedPracticas.add(practica6);



    }

    public static List<Practica> getHarcodedPracticas() {
        return harcodedPracticas;
    }

    public static Practica getPracticaByName(String nombre) {
        for (Practica practica : harcodedPracticas) {
            if (practica.getNombrePractica().equalsIgnoreCase(nombre)) {
                return practica;
            }
        }
        return null; // o lanzar una excepción si no se encuentra la práctica
    }

}