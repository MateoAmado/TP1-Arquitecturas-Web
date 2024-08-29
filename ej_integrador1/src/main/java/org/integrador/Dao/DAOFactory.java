package org.integrador.Dao;
import org.integrador.Util.*;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ClienteDAO getClienteDAO(String type) {
        if (type.equals(ConnectionFactory.MYSQL)) {
            return new ClienteDAOImplMySQL();
        }
        if (type.equals(ConnectionFactory.DERBY)) {
            return new ClienteDAOImplDerby();
        }

        throw new IllegalArgumentException("Tipo de DAO no válido: " + type);

    }

    public FacturaDAO getFacturaDAO(String type) {
        if (type.equals(ConnectionFactory.MYSQL)) {
            return new FacturaDAOImplMySql();
        }
        if (type.equals(ConnectionFactory.DERBY)) {
            return new FacturaDAOImplDerby();
        }

        throw new IllegalArgumentException("Tipo de DAO no válido: " + type);

    }

    public FacturaProductoDAO getFacturaProductoDAO(String type) {
        if (type.equals(ConnectionFactory.MYSQL)) {
            return new FacturaProductoDAOMySql();
        }
        if (type.equals(ConnectionFactory.DERBY)) {
            return new FacturaProductoDAODerby();
        }

        throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
    }

    public ProductoDAO getProductoDAO(String type) {
        if (type.equals(ConnectionFactory.MYSQL)) {
            return new ProductoDAOImplMySql();
        }
        if (type.equals(ConnectionFactory.DERBY)) {
            return new ProductoDAOImplDerby();
        }

        throw new IllegalArgumentException("Tipo de DAO no válido: " + type);

    }
    // otros métodos para obtener instancias de DAOs

}
