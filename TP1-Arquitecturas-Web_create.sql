-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-08-24 22:07:08.041

-- tables
-- Table: cliente
CREATE TABLE cliente (
    idCliente int  NOT NULL,
    nombre varchar(500)  NOT NULL,
    email varchar(150)  NOT NULL,
    CONSTRAINT idCliente PRIMARY KEY (idCliente)
);

-- Table: factura
CREATE TABLE factura (
    idFactura int  NOT NULL,
    idCliente int  NOT NULL,
    CONSTRAINT factura_pk PRIMARY KEY (idFactura)
);

-- Table: factura_producto
CREATE TABLE factura_producto (
    idFactura int  NOT NULL,
    idProducto int  NOT NULL,
    cantidad int  NOT NULL,
    CONSTRAINT factura_producto_pk PRIMARY KEY (idFactura,idProducto)
);

-- Table: producto
CREATE TABLE producto (
    idProducto int  NOT NULL,
    nombre varchar(45)  NOT NULL,
    valor float  NOT NULL,
    CONSTRAINT idProducto PRIMARY KEY (idProducto)
);

-- foreign keys
-- Reference: factura_cliente (table: factura)
ALTER TABLE factura ADD CONSTRAINT factura_cliente FOREIGN KEY factura_cliente (idCliente)
    REFERENCES cliente (idCliente);

-- Reference: factura_producto_factura (table: factura_producto)
ALTER TABLE factura_producto ADD CONSTRAINT factura_producto_factura FOREIGN KEY factura_producto_factura (idFactura)
    REFERENCES factura (idFactura);

-- Reference: factura_producto_producto (table: factura_producto)
ALTER TABLE factura_producto ADD CONSTRAINT factura_producto_producto FOREIGN KEY factura_producto_producto (idProducto)
    REFERENCES producto (idProducto);

-- End of file.

