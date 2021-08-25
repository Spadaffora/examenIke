package com.examenike.demo.modelo;

import javax.persistence.*;

//Mapeo de la tabla estudiantes

@Entity
@Table(name = "estudiantes")
public class EstudianteModelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiante", unique = true, nullable = false)
	private int id_estudiante;

	@Column(name = "nombre", nullable = true, length = 40)
	private String nombre;

	@Column(name = "apellidoPaterno", nullable = true, length = 40)
	private String apellidoPaterno;

	@Column(name = "apellidoMaterno", nullable = true, length = 40)
	private String apellidoMaterno;

	@Column(name = "matricula", nullable = true, length = 40)
	private String matricula;

	// Metodos de acceso
	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
