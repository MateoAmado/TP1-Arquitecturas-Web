package org.integrador.Dao;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ClienteDAO getJugadorDAO(String type) {
        if (type.equals(ConnectionFactory.MYSQL)) {
            return new ClienteDAOImplMySQL();
        }
        if (type.equals(ConnectionFactory.DERBY)) {
            return new ClienteDAOImplDerby();
        }

        throw new IllegalArgumentException("Tipo de DAO no válido: " + type);

    }

    // otros métodos para obtener instancias de DAOs

}
