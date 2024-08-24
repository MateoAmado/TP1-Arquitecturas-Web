package org.integrador.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.integrador.Modelo.Cliente;
import org.integrador.Util.ConnectionFactory;

public class ClienteDAOImplDerby implements ClienteDAO {
    private static Connection connection= ConnectionFactory.instance().connect(ConnectionFactory.DERBY);

    @Override
    public void crear_tabla() {
        try {
            String table= "CREATE TABLE Cliente (idCliente int, nombre varchar(500), email varchar(150), PRIMARY KEY(idCliente))";
            connection.prepareStatement(table).execute();
            connection.commit();
            ConnectionFactory.instance().disconnect();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertar(Cliente cliente) {
        String sql = " INSERT INTO cliente (idCliente, nombre, email) VALUES (?,?,?)";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setInt(1, cliente.getIdCliente();
            stmt.setInt(2, cliente.getNombre();
            stmt.setInt(3, cliente.getEmail();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Cliente cliente) {

    }

    @Override
    public void eliminar(Cliente cliente) {

    }

    @Override
    public Cliente buscar_por_nombre(String nombre) {
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }
}
