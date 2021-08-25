package com.examenike.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

//Mapeo de la tabla materias

@Entity
@Table(name = "materias")
public class MateriaModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_materia", unique = true, nullable = false)
	private int id_materia;

	@Column(name = "nombre_Materia", nullable = true, length = 40)
	private String nombreMateria;

	@OneToOne
	@JoinColumn(name = "calificacion", nullable = true, referencedColumnName = "id_calificacion")
	private CalificacionModelo calificacion;

	
	//Metodos de acceso
	
	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public CalificacionModelo getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(CalificacionModelo calificacion) {
		this.calificacion = calificacion;
	}

}
