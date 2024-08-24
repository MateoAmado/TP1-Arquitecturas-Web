package org.integrador.Dao;

import org.integrador.Modelo.Factura_producto;

import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoDAODerby implements FacturaProductoDAO{

	private static Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
    @Override
    public void crear_tabla() {
    		try {
    			String table= "CREATE TABLE Factura (idFactura INT, idCliente INT, PRIMARY KEY (idFactura), FOREIGN KEY(cliente_idCliente) REFERENCES cliente (idCliente))";
    			connection.prepareStatement(table).execute();
    			connection.commit();
    			ConnectionFactory.instance().disconnect();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}


    @Override
    public void insertar(Factura_producto cliente) {
        	String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
        	   try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
        	          stmt.setInt(1, cliente.getIdFactura());
        	          stmt.setInt(2, cliente.getIdProducto());
        	          stmt.setInt(3, cliente.getCantidad());
        	}
        	   catch(SQLException e){
        	          e.printStackTrace();
        	    }
    }

    @Override
    public void actualizar(Factura_producto cliente) {

    }

    @Override
    public void eliminar(Factura_producto cliente) {

    }

    @Override
    public Factura_producto buscar_por_nombre(String nombre) {
        return null;
    }

    @Override
    public List<Factura_producto> listar() {
        return List.of();
    }
}
