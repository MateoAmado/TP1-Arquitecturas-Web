package org.integrador.Dao;


import org.integrador.Modelo.Cliente;
import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplMySQL implements ClienteDAO {

    @Override
    public void crear_tabla() {
    	try {
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
			String table= "CREATE TABLE cliente (idCliente int, nombre varchar(500), email varchar(150), PRIMARY KEY(idCliente))";
			connection.prepareStatement(table).execute();
			connection.commit();
			ConnectionFactory.instance().disconnect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }


    @Override
    public void insertar(Cliente cliente) {
    	if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
            try {
				/*
				private static void batchInsert(Connection conn) throws SQLException {


            // Suponiendo que tienes una lista de datos
            for (int i = 1; i <= 1000; i++) {
                pstmt.setString(1, "valor1_" + i);
                pstmt.setString(2, "valor2_" + i);
                pstmt.addBatch();  // Añadir a la lista de operaciones por lote

                // Ejecutar el lote cada 100 operaciones para optimizar el rendimiento
                if (i % 100 == 0) {
                    pstmt.executeBatch();
                }
            }

            // Ejecutar cualquier operación restante en el lote
            pstmt.executeBatch();
        }
    }
}
				 */
            	Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
            	String sql = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				for (int i = 1; i <= 1000; i++) {
					stmt.setInt(1, cliente.getIdCliente());
					stmt.setString(2, cliente.getNombre());
					stmt.setString(3, cliente.getEmail());
					stmt.addBatch();
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
    		Connection connection=ConnectionFactory.instance().connect(ConnectionFactory.MYSQL);
    		String sql = "SELECT c.idCliente, c.nombre, c.email, SUM(p.valor * fp.cantidad) AS total_facturado"
    				+ " FROM cliente c JOIN factura f ON c.idCliente = f.idCliente JOIN factura_producto fp "
    				+ "ON f.idFactura = fp.idFactura JOIN producto p ON fp.idProducto = p.idProducto"
    				+ " GROUP BY c.idCliente, c.nombre, c.email ORDER BY total_facturado DESC;";
    		
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
