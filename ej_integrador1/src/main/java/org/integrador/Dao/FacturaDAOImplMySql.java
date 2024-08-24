package org.integrador.Dao;

import org.integrador.Modelo.Factura;
import org.integrador.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FacturaDAOImplMySql implements FacturaDAO{
    private static Connection connection;

    static {
        try {
            connection = ConnectionFactory.instance().connect(ConnectionFactory.DERBY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  void crear_tabla(){
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
    public void insertar(Factura factura) {

        try(PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO factura (idFactura, cliente_idCliente) VALUES (?,?)")){
            String sql = "INSERT INTO factura_producto (idFactura, cliente_idCliente) VALUES (?,?)";
            stmt.setInt(1, factura.getIdFactura());
            stmt.setInt(2, factura.getIdCliente());
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Factura factura) {

    }

    @Override
    public void eliminar(Factura factura) {

    }

    @Override
    public Factura buscar_por_nombre(String nombre) {
        return null;
    }

    @Override
    public List<Factura> listar() {
        return List.of();
    }
}
