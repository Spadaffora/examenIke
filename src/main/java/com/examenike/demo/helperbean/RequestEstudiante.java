package com.examenike.demo.helperbean;

import java.util.List;

import com.examenike.demo.modelo.EstudianteModelo;
import com.examenike.demo.modelo.MateriaModelo;

//Clase de ayuda para la entrega de datos utiles para moldear un objeto en los servicios
public class RequestEstudiante {

	private EstudianteModelo estudianteModelo;
	private List<MateriaModelo> materiaModelo;

	public EstudianteModelo getEstudianteModelo() {
		return estudianteModelo;
	}

	public void setEstudianteModelo(EstudianteModelo estudianteModelo) {
		this.estudianteModelo = estudianteModelo;
	}

	public List<MateriaModelo> getMateriaModelo() {
		return materiaModelo;
	}

	public void setMateriaModelo(List<MateriaModelo> materiaModelo) {
		this.materiaModelo = materiaModelo;
	}

}
