package com.examenike.demo.dto;

public class EstudianteDTO {

	// Creación de variables para la transferencia de datos a moldear
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private int[] materia;

	
	//Metodos de acceso / Encapsulamiento
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int[] getMateria() {
		return materia;
	}

	public void setMateria(int[] materia) {
		this.materia = materia;
	}

}
