package org.integrador.Main;
import org.integrador.Dao.DAOFactory
import org.integrador.Modelo.Cliente;
import org.integrador.Util.ConnectionFactory;

public class Main {
    public static void main(String[] args) {
        DAOFactory dao_factory = DAOFactory.getInstance();
        dao_factory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
        Cliente jugador = dao_factory.getClienteDAO(ConnectionFactory.DERBY).buscar_por_nombre("Nelson");
        System.out.println(jugador.toString());
    }
}