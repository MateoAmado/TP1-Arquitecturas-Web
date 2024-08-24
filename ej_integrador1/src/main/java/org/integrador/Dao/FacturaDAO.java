package org.integrador.Dao;


import org.integrador.Modelo.Factura;

import java.util.List;

public interface FacturaDAO {
    public void crear_tabla();

    public void insertar(Factura cliente);

    public void actualizar(Factura cliente);

    public void eliminar(Factura cliente);

    public Factura buscar_por_nombre(String nombre);

    public List<Factura> listar();
}
