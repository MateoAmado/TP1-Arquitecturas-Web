package org.integrador.Modelo;

public class Factura_producto {

	private int idFactura;
	private int idProducto;
	private int cantidad;
	private int totalRecaudo;
	
	public Factura_producto(int idFactura, int idProducto, int cantidad) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		totalRecaudo=0;
	}

	public Factura_producto(int idFactura, int idProducto, int cantidad, int totalRecaudo) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.totalRecaudo=totalRecaudo;
	}
	
	
	public int getTotalRecaudo() {
		return totalRecaudo;
	}

	public void setTotalRecaudo(int totalRecaudo) {
		this.totalRecaudo = totalRecaudo;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String toString() {
		if(this.totalRecaudo!=0) {
			return "ID de la Factura: "+this.getIdFactura()+"\n"+"ID del producto: "+this.getIdProducto()+"\n"+"Cantidad: "+this.getCantidad()+"\n"
					+"Total recaudado: "+this.getTotalRecaudo()+"\n";
		}
		return "ID de la Factura: "+this.getIdFactura()+"\n"+"ID del producto: "+this.getIdProducto()+"\n"+"Cantidad: "+this.getCantidad()+"\n";
	}
	
	
}
