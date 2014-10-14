package com.psm.Model;

import java.util.Date;

public class Take {
	private int tratamientoId;
	private String tratamiento;
	private int medicinaId;
	private String medicina;
	private int tomaNo;
	private Date fecha;
	private boolean tomada;
	private boolean reprogramada;
	private int usuarioId;
	private String usuario;
	private String icon;
	private int iconDrawableId;
	private int relacionId;
	
	public int getTratamientoId() {
		return tratamientoId;
	}
	public void setTratamientoId(int tratamientoId) {
		this.tratamientoId = tratamientoId;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public int getMedicinaId() {
		return medicinaId;
	}
	public void setMedicinaId(int medicinaId) {
		this.medicinaId = medicinaId;
	}
	public String getMedicina() {
		return medicina;
	}
	public void setMedicina(String medicina) {
		this.medicina = medicina;
	}
	public int getTomaNo() {
		return tomaNo;
	}
	public void setTomaNo(int tomaNo) {
		this.tomaNo = tomaNo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isTomada() {
		return tomada;
	}
	public void setTomada(boolean tomada) {
		this.tomada = tomada;
	}
	public boolean isReprogramada() {
		return reprogramada;
	}
	public void setReprogramada(boolean reprogramada) {
		this.reprogramada = reprogramada;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getIconDrawableId() {
		return iconDrawableId;
	}
	public void setIconDrawableId(int iconDrawableId) {
		this.iconDrawableId = iconDrawableId;
	}
	public int getRelacionId() {
		return relacionId;
	}
	public void setRelacionId(int relacionId) {
		this.relacionId = relacionId;
	}
}
