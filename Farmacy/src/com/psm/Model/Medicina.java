package com.psm.Model;

public class Medicina {
	private int Id;
	private String nombre;
	private String indicacion;
	private int excipienteId;
	private String exipiente;
	private String icon;
	private int activo1Id;
	private String activo1;
	private int activo2Id;
	private String activo2;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIndicacion() {
		return indicacion;
	}
	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}
	public int getExcipienteId() {
		return excipienteId;
	}
	public void setExcipienteId(int excipienteId) {
		this.excipienteId = excipienteId;
	}
	public String getExipiente() {
		return exipiente;
	}
	public void setExipiente(String exipiente) {
		this.exipiente = exipiente;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getActivo1Id() {
		return activo1Id;
	}
	public void setActivo1Id(int activo1Id) {
		this.activo1Id = activo1Id;
	}
	public String getActivo1() {
		return activo1;
	}
	public void setActivo1(String activo1) {
		this.activo1 = activo1;
	}
	public int getActivo2Id() {
		return activo2Id;
	}
	public void setActivo2Id(int activo2Id) {
		this.activo2Id = activo2Id;
	}
	public String getActivo2() {
		return activo2;
	}
	public void setActivo2(String activo2) {
		this.activo2 = activo2;
	}
	
	
}
