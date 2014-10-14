package com.psm.Model;

public class Container {
	private int containerId;
	private String container;
	private String icon;
	
	public Container(int id,String container,String icon)
	{
		this.containerId=id;
		this.container=container;
		this.icon=icon;
	}
	
	public Container()
	{}
	
	public int getContainerId() {
		return containerId;
	}
	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}
