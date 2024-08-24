package org.integrador.Util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.integrador.Modelo.Cliente;
import org.integrador.Modelo.Factura;
import org.integrador.Modelo.Factura_producto;
import org.integrador.Modelo.Producto;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Producto> readCsvProductos() {
        try {
            Path filePath = Paths.get("src/main/resources/csv/productos.csv").normalize().toAbsolutePath();

            try (Reader reader = Files.newBufferedReader(filePath);
                 CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {
                List<Producto> productos = new ArrayList<>();
                for (CSVRecord row : parser) {
                    productos.add(new Producto(Integer.parseInt(row.get("idProducto")), row.get("nombre"), Float.parseFloat(row.get("valor"))));
                }
                return productos;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        public List<Factura> readCsvFacturas() {
            try {
                Path filePath = Paths.get("src/main/resources/csv/facturas.csv").normalize().toAbsolutePath();

                try (Reader reader = Files.newBufferedReader(filePath);
                     CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {
                    List<Factura> facturas= new ArrayList<>();
                    for (CSVRecord row : parser) {
                       facturas.add(new Factura(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idCliente"))));
                    }
                    return facturas;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    public List<Factura_producto> readCsvFacturasProductos() {
        try {
            Path filePath = Paths.get("src/main/resources/csv/facturas-productos.csv").normalize().toAbsolutePath();

            try (Reader reader = Files.newBufferedReader(filePath);
                 CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {
                List<Factura_producto> relacion=new ArrayList<>();
                for (CSVRecord row : parser) {
                    relacion.add(new Factura_producto(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")),Integer.parseInt(row.get("cantidad"))));
                }
                return relacion;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> readCsvClientes() {
        try {
            Path filePath = Paths.get("src/main/resources/csv/facturas-productos.csv").normalize().toAbsolutePath();


            try (Reader reader = Files.newBufferedReader(filePath);
                 CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {
                List<Cliente> clientes = new ArrayList<>();
                for (CSVRecord row : parser) {
                    clientes.add(new Cliente(Integer.parseInt(row.get("idCliente")), row.get("nombre"), row.get("email")));
                }
                return clientes;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
