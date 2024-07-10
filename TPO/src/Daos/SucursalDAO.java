package Daos;

import model.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class SucursalDAO extends GenericDAOImpl<Sucursal, Integer> {

    private List<Sucursal> sucursales = new ArrayList<>();

    @Override
    public Sucursal findById(Integer id) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNumero() == id) {
                return sucursal;
            }
        }
        return null;
    }

    public Sucursal findByNumero(int numero) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNumero() == numero) {
                return sucursal;
            }
        }
        return null;
    }

    @Override
    public List<Sucursal> findAll() {
        return sucursales;
    }

    @Override
    public void create(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    @Override
    public void update(Sucursal sucursal) {
        Sucursal existingSucursal = findById(sucursal.getNumero());
        if (existingSucursal != null) {
            int index = sucursales.indexOf(existingSucursal);
            sucursales.set(index, sucursal);
        }
    }

    @Override
    public void delete(Sucursal sucursal) {
        sucursales.remove(sucursal);
    }
}
