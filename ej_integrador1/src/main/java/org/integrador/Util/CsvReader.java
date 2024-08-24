package org.integrador.Util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvReader {
    public void readCsv() {
        try {
            Path filePath = Paths.get("src/main/resources/csv/productos.csv").normalize().toAbsolutePath();
            System.out.println("Normalized Absolute Path: " + filePath);

            try (Reader reader = Files.newBufferedReader(filePath);
                 CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(reader)) {

                for (CSVRecord row : parser) {
                    System.out.println("ID Producto: " + row.get("idProducto"));
                    System.out.println("Nombre: " + row.get("nombre"));
                    System.out.println("Valor: " + row.get("valor"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
