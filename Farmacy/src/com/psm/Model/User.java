package com.psm.Model;

public class User {

	private int id;
	private String usuario;
	private String edad;
	private String sexo;
	
	public User(int id, String usuario, String edad, String sexo)
	{
		this.id = id;
		this.usuario = usuario;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
