package com.psm.Model;

public class Active {
	
	private String Name;
	private int Id;
	
	public Active(String name, int id)
	{
		Name=name;
		Id=id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
