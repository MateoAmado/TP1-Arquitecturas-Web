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
       lectorcsv.readCsvProductos();
       
       
       DAOFactory dao_factory = DAOFactory.getInstance();
       ClienteDAO mysqlCliente =dao_factory.getClienteDAO(ConnectionFactory.MYSQL);
       /*
       //dao_factory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
        List<Cliente> clientes=lectorcsv.readCsvClientes();
        	System.out.println(clientes.size());
	        for(Cliente cliente:clientes){
	           mysqlCliente.insertar(cliente);
	        }
        
     
       //dao_factory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
        
       FacturaDAO mysqlFactura=DAOFactory.getInstance().getFacturaDAO(ConnectionFactory.MYSQL);
        List<Factura> facturas=lectorcsv.readCsvFacturas();
        System.out.println(facturas.size());
        for(Factura factura:facturas){
            mysqlFactura.insertar(factura);
        }
        
      
        ProductoDAO mysqlProducto = dao_factory.getProductoDAO(ConnectionFactory.MYSQL);
        List<Producto> productos = lectorcsv.readCsvProductos();
        for(Producto p:productos) {
        	mysqlProducto.insertar(p);
        }
        System.out.println("asd");
      
       //dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
        
       FacturaProductoDAO mysqlProductoFactura=dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL); 
        
        
        List<Factura_producto> fp=lectorcsv.readCsvFacturasProductos();
        //Factura_producto producto=mysqlProducto.producto_que_mas_recaudo();
        System.out.println("hola");
        for(Factura_producto fp1:fp){
            mysqlProductoFactura.insertar(fp1);
        }
        */
        
        System.out.print("Clientes por facturacion");
       List<Cliente> clientes_f=mysqlCliente.clientes_por_facturacion();
       for(Cliente cliente:clientes_f){
           System.out.println(cliente.ToString());
        }
       
       
      ClienteDAO clienteDerby = dao_factory.getClienteDAO(ConnectionFactory.DERBY);
       dao_factory.getClienteDAO(ConnectionFactory.DERBY).crear_tabla();
       
       System.out.println("clienteDerby:");
       List<Cliente> clentes = lectorcsv.readCsvClientes();
       for(Cliente cliente:clentes) {
    	   clienteDerby.insertar(cliente);
       }
       
       FacturaDAO facturaDerby = dao_factory.getFacturaDAO(ConnectionFactory.DERBY);
       dao_factory.getFacturaDAO(ConnectionFactory.DERBY).crear_tabla();
       
       List<Factura> facturas = lectorcsv.readCsvFacturas();
       for(Factura factura:facturas) {
    	   facturaDerby.insertar(factura);
       }
	     
        
        
    }
}