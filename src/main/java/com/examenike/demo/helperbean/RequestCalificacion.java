package com.examenike.demo.helperbean;

import java.util.List;

import com.examenike.demo.dto.MateriaDTO;
import com.examenike.demo.modelo.EstudianteModelo;


//Clase de ayuda para la entrega de datos utiles para moldear un objeto en los servicios
public class RequestCalificacion {

	private EstudianteModelo estudianteModelo;
	private List<MateriaDTO> materiadto;

	public EstudianteModelo getEstudianteModelo() {
		return estudianteModelo;
	}

	public void setEstudianteModelo(EstudianteModelo estudianteModelo) {
		this.estudianteModelo = estudianteModelo;
	}

	public List<MateriaDTO> getMateriadto() {
		return materiadto;
	}

	public void setMateriadto(List<MateriaDTO> materiadto) {
		this.materiadto = materiadto;
	}

}
