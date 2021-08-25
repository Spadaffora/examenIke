package com.examenike.demo.dto;

public class MateriaDTO {

	// Creación de variables para la transferencia de datos a moldear
	private int id_materia;
	private String nombre;
	private Integer calificacion;

	// Metodos de acceso / Encapsulamiento
	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

}
