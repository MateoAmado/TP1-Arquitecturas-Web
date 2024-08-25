package org.integrador.Dao;

import org.integrador.Modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface ClienteDAO {
    public void crear_tabla();

    public void insertar(Cliente cliente);

    public void actualizar(Cliente cliente);

    public void eliminar(Cliente cliente);

    public Cliente buscar_por_nombre(String nombre);

    public ArrayList<Cliente> clientes_por_facturacion();

}
