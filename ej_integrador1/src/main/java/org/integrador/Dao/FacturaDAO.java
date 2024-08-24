package org.integrador.Dao;


import org.integrador.Modelo.Factura;

import java.util.List;

public interface FacturaDAO {
    public void crear_tabla();

    public void insertar(Factura factura);

    public void actualizar(Factura factura);

    public void eliminar(Factura factura);

    public Factura buscar_por_nombre(String nombre);

    public List<Factura> listar();
}
