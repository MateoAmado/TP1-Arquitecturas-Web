package org.integrador.Dao;

import org.integrador.Modelo.Factura_producto;

import java.util.List;

public interface FacturaProductoDAO {
    public void crear_tabla();

    public void insertar(Factura_producto facturaProducto);

    public void actualizar(Factura_producto facturaProducto);

    public void eliminar(Factura_producto facturaProducto);

    public Factura_producto buscar_por_nombre(String nombre);

    public Factura_producto producto_que_mas_recaudo();
    public List<Factura_producto> listar();
}
