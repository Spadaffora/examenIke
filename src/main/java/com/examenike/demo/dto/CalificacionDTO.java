package com.examenike.demo.dto;

public class CalificacionDTO {

	//Creación de variables para la transferencia de datos a moldear
	private int id_Materia;
	private int id_Estudiante;
	private int calificacion;

	
	//Metodos de acceso / Encapsulamiento	
	public int getId_Materia() {
		return id_Materia;
	}

	public void setId_Materia(int id_Materia) {
		this.id_Materia = id_Materia;
	}

	public int getId_Estudiante() {
		return id_Estudiante;
	}

	public void setId_Estudiante(int id_Estudiante) {
		this.id_Estudiante = id_Estudiante;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}
