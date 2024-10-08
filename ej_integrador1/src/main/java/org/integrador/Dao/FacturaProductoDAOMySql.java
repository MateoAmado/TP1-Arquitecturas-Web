package org.integrador.Dao;

import org.integrador.Modelo.Factura_producto;
import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FacturaProductoDAOMySql implements FacturaProductoDAO {
	



    @Override
    public void crear_tabla() {
    	try {
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
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
    public void insertar(List<Factura_producto> facturaProductos) {
		int i=0;
    	   try{
    		   Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
    		   String sql = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?,?,?)";
    		   PreparedStatement stmt = connection.prepareStatement(sql);
			   for(Factura_producto facturaProducto: facturaProductos) {
				   stmt.setInt(1, facturaProducto.getIdFactura());
				   stmt.setInt(2, facturaProducto.getIdProducto());
				   stmt.setInt(3, facturaProducto.getCantidad());
				   stmt.addBatch();
				   i++;

				   if(i % 100 == 0){
					   stmt.executeBatch();
				   }

			   }
			      stmt.executeBatch();
    	          connection.commit();
    	          ConnectionFactory.instance().disconnect();
    	}
    	   catch(SQLException e){
    	          e.printStackTrace();
    	    }
    }
    
    public Factura_producto producto_que_mas_recaudo() {
    	try {
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
    		String sql = "SELECT cantidad,idFactura,fp.idProducto,p.valor, SUM(cantidad*p.valor) AS total_Cantidad"
    				+ " FROM factura_producto fp"
    				+ " JOIN producto p ON p.idProducto = fp.idProducto"
    				+ " GROUP BY fp.idProducto"
    				+ " ORDER BY total_Cantidad DESC"
    				+ " LIMIT 1";
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		if(rs.next()) {
    			int cantidad=rs.getInt("cantidad");
    			int idProducto=rs.getInt("idProducto");
    			int IdFactura=rs.getInt("idFactura");
    			int totalRecaudo=rs.getInt("total_Cantidad");
    			return new Factura_producto(IdFactura, idProducto, cantidad, totalRecaudo);
    		}
    		ConnectionFactory.instance().disconnect();
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
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
