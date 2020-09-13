package com.my.alumnos.entity;

import java.util.Date;

public class Alumno {
	
	private int id;
	private String nombres;
	private String apellidos;
	private String email;
	private Date fechaCrea;
	

	public Alumno() {
	}
	
	public Alumno(int id, String nombres, String apellidos, String email) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFechaCrea() {
		return fechaCrea;
	}


	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Alumno [nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", fechaCrea="
				+ fechaCrea + "]";
	}
	
	
	

}
