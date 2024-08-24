package org.integrador.Main;
import org.integrador.Dao.*;
import org.integrador.Modelo.Cliente;
import org.integrador.Modelo.Factura;
import org.integrador.Modelo.Factura_producto;
import org.integrador.Modelo.Producto;
import org.integrador.Util.ConnectionFactory;
import org.integrador.Util.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReader lectorcsv=new CsvReader();
     /*   lectorcsv.readCsvProductos();
        DAOFactory dao_factory = DAOFactory.getInstance();
        dao_factory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
        Cliente jugador = dao_factory.getClienteDAO(ConnectionFactory.DERBY).buscar_por_nombre("Nelson");
        System.out.println(jugador.toString());
       List<Cliente> clientes=lectorcsv.readCsvClientes();

        System.out.println(clientes.size());
        for(Cliente cliente:clientes){
           mysqlCliente.insertar(cliente);
        }
          FacturaDAOImplMySql mysqlFactura=new FacturaDAOImplMySql();

        List<Factura> facturas=lectorcsv.readCsvFacturas();
        System.out.println(facturas.size());
        for(Factura factura:facturas){
            mysqlFactura.insertar(factura);
        }
        */
/*
        ProductoDAOImplMySql ProdDao=new ProductoDAOImplMySql();
        List<Producto> productos=lectorcsv.readCsvProductos();
        for(Producto prod:productos){
            ProdDao.insertar(prod);
        }
*/

     //   ClienteDAOImplMySQL mysqlCliente=new ClienteDAOImplMySQL();
        FacturaProductoDAOMySql fpd=new FacturaProductoDAOMySql();
        List<Factura_producto> fp=lectorcsv.readCsvFacturasProductos();
        for(Factura_producto fp1:fp){
            fpd.insertar(fp1);
        }
       // ProductoDAOImplMySql pdf=new ProductoDAOImplMySql();


    }
}