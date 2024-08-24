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

	private ConnectionFactory connectionFactory;
	
	public ClienteDAOImplMySQL() {
		this.connectionFactory = ConnectionFactory.instance();
	}
	
	
    @Override
    public void crear_tabla() {
    	try {
			String table= "CREATE TABLE cliente (idCliente int, nombre varchar(500), email varchar(150), PRIMARY KEY(idCliente))";
			connectionFactory.connect(connectionFactory.MYSQL).prepareStatement(table).execute();
			connectionFactory.connect(connectionFactory.MYSQL).commit();
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

        String sql = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?,?,?)";
        Connection conn = null;
        try {
            conn = this.connectionFactory.connect(connectionFactory.MYSQL);
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cliente.getIdCliente());
                stmt.setString(2, cliente.getNombre());
                stmt.setString(3, cliente.getEmail());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar el cliente: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
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
    		String sql = "SELECT c.idCliente, c.nombre, SUM(p.valor * fp.cantidad) AS total_facturado " +
                    "FROM cliente c " +
                    "JOIN factura f ON c.idCliente = f.cliente_idCliente " +
                    "JOIN factura_producto fp ON f.idFactura = fp.factura_idFactura " +
                    "JOIN producto p ON fp.producto_idProducto = p.idProducto " +
                    "GROUP BY c.idCliente, c.nombre " +
                    "ORDER BY total_facturado DESC";
    		
    		PreparedStatement stmt = this.connectionFactory.connect(connectionFactory.MYSQL).prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		while(rs.next()) {
    			int idCliente = rs.getInt("idCliente");
    			String nombre = rs.getString("nombre");
    			String email = rs.getString("email");
    			Cliente cliente = new Cliente(idCliente, nombre, email);
    			clientes.add(cliente);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
  
    	return clientes;  	    
    }
    
    @Override
    public Cliente buscar_por_nombre(String nombre) {
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return List.of();
    }
}
