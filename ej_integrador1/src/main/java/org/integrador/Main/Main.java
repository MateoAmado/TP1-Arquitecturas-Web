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
       
       /*
       DAOFactory dao_factory = DAOFactory.getInstance();
       ClienteDAO mysqlCliente =dao_factory.getClienteDAO(ConnectionFactory.MYSQL);
       //dao_factory.getClienteDAO(ConnectionFactory.MYSQL).crear_tabla();
        List<Cliente> clientes=lectorcsv.readCsvClientes();
        	System.out.println(clientes.size());
        
	        for(Cliente cliente:clientes){
	           mysqlCliente.insertar(cliente);
	        }
        */
        
        /*
       ArrayList<Cliente> clientes=mysqlCliente.clientes_por_facturacion();
       for(Cliente cliente:clientes){
           System.out.println(cliente.ToString());
        }
	     */
        
        
       
       
       /*
       DAOFactory dao_factory = DAOFactory.getInstance();
       //dao_factory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
        
       FacturaDAO mysqlFactura=DAOFactory.getInstance().getFacturaDAO(ConnectionFactory.MYSQL);

        List<Factura> facturas=lectorcsv.readCsvFacturas();
        System.out.println(facturas.size());
        
        for(Factura factura:facturas){
            mysqlFactura.insertar(factura);
        }
        
        */
        
       /*
       DAOFactory dao_factory = DAOFactory.getInstance();
       //dao_factory.getProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
        
       ProductoDAO mysqlProducto=DAOFactory.getInstance().getProductoDAO(ConnectionFactory.MYSQL); 
       
        List<Producto> productos=lectorcsv.readCsvProductos();
        
        System.out.println(productos.size());
        for(Producto prod:productos){
        	mysqlProducto.insertar(prod);
        }

		*/
		
      
      DAOFactory dao_factory = DAOFactory.getInstance();
       //dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();
        
       FacturaProductoDAO mysqlProducto=dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL); 
        
        
        List<Factura_producto> fp=lectorcsv.readCsvFacturasProductos();
        
        Factura_producto producto=mysqlProducto.producto_que_mas_recaudo();
        System.out.println(producto.toString());
        /*for(Factura_producto fp1:fp){
            fpd.insertar(fp1);
        }*/
        
    }
}