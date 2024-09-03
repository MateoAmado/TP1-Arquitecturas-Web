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
    private static ClienteDAO Cliente =(ClienteDAO) dao_factory.getDAO(DAOFactory.CLIENTE, ConnectionFactory.DERBY);
    private static FacturaProductoDAO ProductoFactura=(FacturaProductoDAO) dao_factory.getDAO(DAOFactory.FACTURA_PRODUCTO, ConnectionFactory.DERBY);
    private static ProductoDAO Producto = (ProductoDAO) dao_factory.getDAO(DAOFactory.PRODUCTO ,ConnectionFactory.DERBY);
    private static FacturaDAO Factura=(FacturaDAO) DAOFactory.getInstance().getDAO(DAOFactory.FACTURA ,ConnectionFactory.DERBY);

    public static void main(String[] args) {
        Cliente.crear_tabla();
        Factura.crear_tabla();
        Producto.crear_tabla();
        ProductoFactura.crear_tabla();
        
        insertarCliente();
        insertarFactura();
        insertarProducto();
        insertarProductoFactura();
        imprimirClientesPorFacturacion();
        mejorProducto();
     
    }

    public static void insertarCliente(){
        List<Cliente> clientes=lectorcsv.readCsvClientes();
            Cliente.insertar(clientes);
        
    }

    public static void insertarFactura(){
        List<Factura> facturas=lectorcsv.readCsvFacturas();
            Factura.insertar(facturas);

    }

    public static void insertarProducto(){
        List<Producto> productos = lectorcsv.readCsvProductos();

            Producto.insertar(productos);

    }

    public static void insertarProductoFactura(){
        List<Factura_producto> fp=lectorcsv.readCsvFacturasProductos();
            ProductoFactura.insertar(fp);

    }

    public static void imprimirClientesPorFacturacion(){

        System.out.print("Clientes por facturacion");
        List<Cliente> clientes_f=Cliente.clientes_por_facturacion();
        for(Cliente cliente:clientes_f){
            System.out.println(cliente.ToString());
        }
    }
    
    public static void mejorProducto() {
    	System.out.println("Producto que mas recaudo");
    	Factura_producto p = ProductoFactura.producto_que_mas_recaudo();
    	System.out.println(p);
    }
}