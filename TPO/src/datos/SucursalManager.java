package datos;

import model.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class SucursalManager {

    private static List<Sucursal> harcodedSucursales = new ArrayList<>();

    static {
        Sucursal sucursal1 = new Sucursal();
        harcodedSucursales.add(sucursal1);

    }

}