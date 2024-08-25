package org.integrador.Dao;

import org.integrador.Modelo.Factura_producto;

import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoDAODerby implements FacturaProductoDAO{
	
	public static Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);


    @Override
    public void crear_tabla() {
    	try {
    		String table = "CREATE TABLE factura_producto ("
    		           + "idFactura INT, "
    		           + "idProducto INT, "
    		           + "cantidad INT, "
    		           + "PRIMARY KEY (idFactura, idProducto), "
    		           + "FOREIGN KEY (idProducto) REFERENCES producto(idProducto), "
    		           + "FOREIGN KEY (idFactura) REFERENCES factura(IdFactura)"
    		           + ");";
			connection.prepareStatement(table).execute();
			connection.commit();
			ConnectionFactory.instance().disconnect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void insertar(Factura_producto facturaProducto) {
    	   try{
    		   String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
    		   PreparedStatement stmt = this.connection.prepareStatement(sql);
    	          stmt.setInt(1, facturaProducto.getIdFactura());
    	          stmt.setInt(2, facturaProducto.getIdProducto());
    	          stmt.setInt(3, facturaProducto.getCantidad());
    	          stmt.executeUpdate();
    	          connection.commit();
    	}
    	   catch(SQLException e){
    	          e.printStackTrace();
    	    }
    }

    @Override
    public void actualizar(Factura_producto facturaProducto) {

    }

    @Override
    public void eliminar(Factura_producto facturaProducto) {

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