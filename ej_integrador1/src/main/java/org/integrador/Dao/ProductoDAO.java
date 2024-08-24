package org.integrador.Dao;

import org.integrador.Modelo.Producto;

import java.util.List;

public interface ProductoDAO {
    public void crear_tabla();

    public void insertar(Producto cliente);

    public void actualizar(Producto cliente);

    public void eliminar(Producto cliente);

    public Producto buscar_por_nombre(String nombre);

    public List<Producto> listar();
}
