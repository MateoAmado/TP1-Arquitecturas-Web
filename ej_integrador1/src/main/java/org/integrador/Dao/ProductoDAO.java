package org.integrador.Dao;

import org.integrador.Modelo.Producto;

import java.util.List;

public interface ProductoDAO {
    public void crear_tabla();

    public void insertar(List<Producto> producto);

    public void actualizar(Producto producto);

    public void eliminar(Producto producto);

    public Producto buscar_por_nombre(String nombre);

    public List<Producto> listar();
}
