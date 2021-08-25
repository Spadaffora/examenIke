package com.examenike.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examenike.demo.dto.CalificacionDTO;
import com.examenike.demo.helperbean.Response;
import com.examenike.demo.servicios.CalificacionServicio;

//Controlador que se encarga de crear los mmicro-servicios orientados a la calificacion de un estudiante
//endpoint de acceso http://localhost:8080/calificacion/
@RequestMapping(value = "/calificacion")
@RestController
public class CalificacionControlador {

//Inyección de dependencias	a un objeto	
	@Autowired
	CalificacionServicio calificacionServicio;

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/calificacion/insert Tipo POST
	 * 
	 * @param calificaciondto
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Response> insertarCalificacion(@RequestBody CalificacionDTO calificaciondto) {

		return calificacionServicio.insertarCalificacion(calificaciondto);

	}

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/calificacion/delete Tipo DELETE
	 * 
	 * @param calificaciondto
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Response> eliminarCalificacion(@RequestBody CalificacionDTO calificaciondto) {

		return calificacionServicio.eliminarCalificacion(calificaciondto);

	}

	/**
	 * API que permite la inserción de una calificación para un estudiante Endpoint
	 * de acceso http://localhost:8080/calificacion/delete Tipo PUT
	 * 
	 * @param calificaciondto
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseEntity<Response> modificarCalificacion(@RequestBody CalificacionDTO calificaciondto) {

		return calificacionServicio.modificarCalificacion(calificaciondto);

	}

}
