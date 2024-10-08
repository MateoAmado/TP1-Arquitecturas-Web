package org.integrador.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.integrador.Modelo.Cliente;
import org.integrador.Util.ConnectionFactory;

public class ClienteDAOImplDerby implements ClienteDAO {
	
	
	
	
    @Override
    public void crear_tabla() {
    	try {
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
			String table= "CREATE TABLE cliente (idCliente int, nombre varchar(500), email varchar(150), PRIMARY KEY(idCliente))";
			connection.prepareStatement(table).execute();
			connection.commit();
			ConnectionFactory.instance().disconnect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }


    @Override
    public void insertar(List<Cliente> clientes) {
		int i=0;
		if (clientes == null) {
			throw new IllegalArgumentException("El cliente no puede ser null");
		}
		try {
			Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
			String sql = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			for(Cliente cliente: clientes) {
				stmt.setInt(1, cliente.getIdCliente());
				stmt.setString(2, cliente.getNombre());
				stmt.setString(3, cliente.getEmail());
				stmt.addBatch();
				i++;
				if(i % 100 == 0){
					stmt.executeBatch();
				}

			}
			stmt.executeBatch();
			connection.commit();
			ConnectionFactory.instance().disconnect();
		} catch (SQLException e) {
			System.err.println("Error al insertar el cliente: " + e.getMessage());
		}
    }




    @Override
    public void actualizar(Cliente cliente) {

    }

    @Override
    public void eliminar(Cliente cliente) {

    }

    public ArrayList<Cliente> clientes_por_facturacion() {
    	ArrayList<Cliente> clientes = new ArrayList();
    	try {
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
    		String sql = "SELECT c.idCliente, c.nombre, c.email, SUM(p.valor * fp.cantidad) AS total_facturado"
    				+ " FROM cliente c JOIN factura f ON c.idCliente = f.idCliente JOIN factura_producto fp "
    				+ "ON f.idFactura = fp.idFactura JOIN producto p ON fp.idProducto = p.idProducto"
    				+ " GROUP BY c.idCliente, c.nombre, c.email ORDER BY total_facturado DESC";
    		
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			int idCliente = rs.getInt("idCliente");
    			String nombre = rs.getString("nombre");
    			String email = rs.getString("email");
    			Cliente cliente = new Cliente(idCliente, nombre, email);
    			clientes.add(cliente);
    		}
    		ConnectionFactory.instance().disconnect();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
  
    	return clientes;  	    
    }
    
    @Override
    public Cliente buscar_por_nombre(String nombre) {
        return null;
    }

}