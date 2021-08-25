package com.examenike.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examenike.demo.dto.EstudianteDTO;
import com.examenike.demo.helperbean.Response;

import com.examenike.demo.servicios.EstudianteServicio;

//Controlador que se encarga de crear los mmicro-servicios orientados a la calificacion de un estudiante
//endpoint de acceso http://localhost:8080/estudiante/
@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {

	// Inyección de dependencias a un objeto
	@Autowired
	EstudianteServicio estudianteServicio;

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/estudiante/consultar Tipo GET
	 * 
	 * @param estudiantedto
	 */
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public ResponseEntity<Response> consularEstudiante() {
		return estudianteServicio.consultarEstudiante();
	}

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/estudiante/registrar Tipo POST
	 * 
	 * @param estudiantedto
	 */
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Response> registrarEstudiante(@RequestBody EstudianteDTO estudiantedto) {
		return estudianteServicio.registrarEstudiante(estudiantedto);
	}

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/estudiante/consultarCalificacion Tipo GET
	 */
	@RequestMapping(value = "/consultarCalificacion", method = RequestMethod.GET)
	public ResponseEntity<Response> consultarCalificacionEstudiante() {
		return estudianteServicio.consultarCalificacionEstudiante();
	}

}
