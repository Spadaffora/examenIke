package com.examenike.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Mapeo de la tabla calificaciones

@Entity
@Table(name = "calificaciones")
public class CalificacionModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calificacion", unique = true, nullable = false)
	private int calificacion_id;

	@Column(name = "valor", length = 40)
	private Integer valor;

	@ManyToOne
	@JoinColumn(name = "estudiante", referencedColumnName = "id_estudiante")
	private EstudianteModelo estudiante;

	@ManyToOne
	@JoinColumn(name = "materia", referencedColumnName = "id_materia")
	private MateriaModelo materia;

	// Metodos de acceso
	public int getCalificacion_id() {
		return calificacion_id;
	}

	public void setCalificacion_id(int calificacion_id) {
		this.calificacion_id = calificacion_id;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public EstudianteModelo getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteModelo estudiante) {
		this.estudiante = estudiante;
	}

	public MateriaModelo getMateria() {
		return materia;
	}

	public void setMateria(MateriaModelo materia) {
		this.materia = materia;
	}

}
