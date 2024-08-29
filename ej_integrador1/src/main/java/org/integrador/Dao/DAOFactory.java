package org.integrador.Dao;
import org.integrador.Util.*;

public class DAOFactory {
    private static DAOFactory instance = new DAOFactory();
    public static final String CLIENTE = "cliente";
    public static final String PRODUCTO = "producto";
    public static final String FACTURA = "factura";
    public static final String FACTURA_PRODUCTO = "factura_producto";
    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }
    
    public Object getDAO(String dao, String type) {
    	switch(dao) {
    	case CLIENTE :
    		if (type.equals(ConnectionFactory.MYSQL)) {
                return new ClienteDAOImplMySQL();
            }
            if (type.equals(ConnectionFactory.DERBY)) {
                return new ClienteDAOImplDerby();
            }          
    		break;
    	case PRODUCTO :
    		if (type.equals(ConnectionFactory.MYSQL)) {
                return new ProductoDAOImplMySql();
            }
            if (type.equals(ConnectionFactory.DERBY)) {
                return new ProductoDAOImplDerby();
            }     
    		break;  
    	case FACTURA :
    		if (type.equals(ConnectionFactory.MYSQL)) {
                return new FacturaDAOImplMySql();
            }
            if (type.equals(ConnectionFactory.DERBY)) {
                return new FacturaDAOImplDerby();
            }     
    		break;  
    	case FACTURA_PRODUCTO :
    		 if (type.equals(ConnectionFactory.MYSQL)) {
    	            return new FacturaProductoDAOMySql();
    	        }
    	        if (type.equals(ConnectionFactory.DERBY)) {
    	            return new FacturaProductoDAODerby();
    	        }  
    		break;  
		default:
			 throw new IllegalArgumentException("Tipo de DAO no válido: " + type);
    	}
    	return null;
    }
    // otros métodos para obtener instancias de DAOs

}
