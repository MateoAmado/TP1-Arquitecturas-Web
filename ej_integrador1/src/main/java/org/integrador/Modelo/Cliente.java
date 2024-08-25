package org.integrador.Modelo;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String email;
	
	public Cliente(int idCliente, String nombre, String email) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String ToString() {
		return "Nombre: "+this.getNombre()+"\n"+"Email: "+this.getEmail()+"\n"+"IdCLiente: "+this.getIdCliente()+"\n";
		
	}
	
	
}
