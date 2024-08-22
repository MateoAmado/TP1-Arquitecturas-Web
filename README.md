# Ejercicio Integrador - Arquitecturas Web : Gestión de Base de Datos con JDBC

Este proyecto demuestra el uso de JDBC para la gestión de bases de datos y la carga de datos desde archivos CSV. El proyecto abarca la creación del esquema de la base de datos, la carga de datos desde archivos CSV, y la realización de consultas específicas para extraer información significativa.

## Funcionalidades

1. **Creación del Esquema de la Base de Datos**  
   Un programa que crea el esquema de la base de datos utilizando JDBC.

2. **Carga de Datos desde CSV**  
   Un programa JDBC que carga datos desde archivos CSV a la base de datos utilizando la biblioteca Apache Commons CSV. Ejemplo:
   ```java
   CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("productos.csv"));
   for (CSVRecord row : parser) {
       System.out.println(row.get("idProducto"));
       System.out.println(row.get("nombre"));
       System.out.println(row.get("valor"));
   }

'''
3. **Escriba un programa JDBC que retorne el producto que más recaudó. Se define “recaudación” como cantidad de productos vendidos multiplicado por su valor.**

4. **Escriba un programa JDBC que imprima una lista de clientes, ordenada por a cuál se le facturó más. **
