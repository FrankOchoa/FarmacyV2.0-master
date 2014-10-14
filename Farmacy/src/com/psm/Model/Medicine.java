package com.psm.Model;

import java.util.ArrayList;
import java.util.List;

public class Medicine {
	private int Id;
	private String nombre;
	private String indicacion;	
	private String icon;
	private Container excipiente;
	private List<Active>activos;
	
	public Medicine()
	{
		activos= new ArrayList<Active>();
		excipiente= new Container();
	}
	
	
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}	
	public List<Active> getActivos() {
		return activos;
	}
	public void setActivos(List<Active> activos) {
		this.activos = activos;
	}

	public Container getExcipiente() {
		return excipiente;
	}

	public void setExcipiente(Container excipiente) {
		this.excipiente = excipiente;
	}	
	
}
