package org.integrador.Dao;

import org.integrador.Modelo.Producto;
import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductoDAOImplMySql implements ProductoDAO{
	private static Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
	
    @Override
    public void crear_tabla() {
    	try {
			String table= "CREATE TABLE producto (idProducto int , nombre varchar(45), valor float,PRIMARY KEY (idProducto))";
			connection.prepareStatement(table).execute();
			connection.commit();
			ConnectionFactory.instance().disconnect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

    @Override
    public void insertar(Producto producto) {
    	String sql = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?,?,?)";
    	   try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
    	          stmt.setInt(1, producto.getIdProducto());
    	          stmt.setString(2, producto.getNombre());
    	          stmt.setFloat(3, producto.getValor());
    	}
    	   catch(SQLException e){
    	          e.printStackTrace();
    	    }

    }


    @Override
    public void actualizar(Producto cliente) {

    }

    @Override
    public void eliminar(Producto cliente) {

    }

    @Override
    public Producto buscar_por_nombre(String nombre) {
        return null;
    }

    @Override
    public List<Producto> listar() {
        return List.of();
    }
}
