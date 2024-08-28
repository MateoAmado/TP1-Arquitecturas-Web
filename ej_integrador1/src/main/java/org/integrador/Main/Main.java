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
    private static CsvReader lectorcsv=new CsvReader();
    private static DAOFactory dao_factory = DAOFactory.getInstance();
    private static ClienteDAO mysqlCliente =dao_factory.getClienteDAO(ConnectionFactory.MYSQL);
    private static FacturaProductoDAO mysqlProductoFactura=dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL);
    private static ProductoDAO mysqlProducto = dao_factory.getProductoDAO(ConnectionFactory.MYSQL);
    private static FacturaDAO mysqlFactura=DAOFactory.getInstance().getFacturaDAO(ConnectionFactory.MYSQL);

    public static void main(String[] args) {
        lectorcsv.readCsvProductos();
       //dao_factory.getFacturaDAO(ConnectionFactory.MYSQL).crear_tabla();
       //dao_factory.getFacturaProductoDAO(ConnectionFactory.MYSQL).crear_tabla();

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

    public static void insertarCliente(){
        List<Cliente> clientes=lectorcsv.readCsvClientes();
        System.out.println(clientes.size());
        for(Cliente cliente:clientes){
            mysqlCliente.insertar(cliente);
        }
    }

    public static void insertarFactura(){
        List<Factura> facturas=lectorcsv.readCsvFacturas();
        System.out.println(facturas.size());
        for(Factura factura:facturas){
            mysqlFactura.insertar(factura);
        }
    }

    public static void insertarProducto(){
        List<Producto> productos = lectorcsv.readCsvProductos();
        for(Producto p:productos) {
            mysqlProducto.insertar(p);
        }
    }

    public static void insertarProductoFactura(){
        List<Factura_producto> fp=lectorcsv.readCsvFacturasProductos();
        System.out.println("hola");
        for(Factura_producto fp1:fp){
            mysqlProductoFactura.insertar(fp1);
        }
    }

    public static void imprimirClientesPorFacturacion(){
        System.out.print("Clientes por facturacion");
        List<Cliente> clientes_f=mysqlCliente.clientes_por_facturacion();
        for(Cliente cliente:clientes_f){
            System.out.println(cliente.ToString());
        }
    }
}