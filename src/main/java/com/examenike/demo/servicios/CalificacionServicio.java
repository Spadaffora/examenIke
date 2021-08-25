package com.examenike.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examenike.demo.dto.CalificacionDTO;
import com.examenike.demo.helperbean.Response;
import com.examenike.demo.repositorios.CalificacionRepositorio;

@Service
public class CalificacionServicio {

	@Autowired
	CalificacionRepositorio calificacionRepositorio;

	
	/**
	 * Metodo para la inserción de una calificacion
	 * @param calificaciondto
	 * @return Response
	 */
	public ResponseEntity<Response> insertarCalificacion(CalificacionDTO calificaciondto) {
		
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		
		//Variable para la validar la respuesta de la consulta
		Integer responseConsulta;
		try {
			//Se llama el metodo del repositorio que aunado a los parametros de la consulta nativa se iguala a la obtencion de cada uno 
			//de los valores getCalificacion, getId_Estudiante, getId_Materia
			responseConsulta = calificacionRepositorio.actulizarCalificacion(calificaciondto.getCalificacion(),
					calificaciondto.getId_Estudiante(), calificaciondto.getId_Materia());
			//La respuesta es de tipo entero, cuando esta es exitosa es igual a 1, de lo contrario es 0 por lo tanto se condiciona
			if (responseConsulta == 1) {
				//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
				response.setErrorCode(001);
				response.setInfoError("Calificacion registrada exitosamente!");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(404);
			response.setInfoError("Calificacion no registrada por error en la base de datos");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
			//Manejo de excepciones generales
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(405);
			response.setInfoError("La calificacion desafortunadamente no pudo registrarse");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

	}

	
	
	/**
	 * Metodo para la eliminación de una calificacion
	 * @param calificaciondto
	 * @return Response
	 */
	public ResponseEntity<Response> eliminarCalificacion(CalificacionDTO calificaciondto) {
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		//Variable para la validar la respuesta de la consulta
		Integer responseConsulta;
		try {
			responseConsulta = calificacionRepositorio.eliminarCalificacion(calificaciondto.getId_Estudiante(),
					calificaciondto.getId_Materia());
			//La respuesta es de tipo entero, cuando esta es exitosa es igual a 1, de lo contrario es 0 por lo tanto se condiciona
			if (responseConsulta == 1) {
				response.setErrorCode(200);
				response.setInfoError("Calificacion eliminada exitosamente!");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}else {
			response.setErrorCode(400);
			response.setInfoError("Calificacion no eliminada por error en la base de datos");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setErrorCode(400);
			response.setInfoError("La Calificacion no se pudó eliminar");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

	}
	
	
	/**
	 * Metodo para la modificacion de una calificacion
	 * @param calificaciondto
	 * @return Response
	 */
	public ResponseEntity<Response> modificarCalificacion(CalificacionDTO calificaciondto) {
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		//Variable para la validar la respuesta de la consulta
		Integer responseConsulta;
		try {
			responseConsulta = calificacionRepositorio.actulizarCalificacion(calificaciondto.getCalificacion(),
					calificaciondto.getId_Estudiante(), calificaciondto.getId_Materia());
			//La respuesta es de tipo entero, cuando esta es exitosa es igual a 1, de lo contrario es 0 por lo tanto se condiciona
			if (responseConsulta == 1) {
				response.setErrorCode(200);
				response.setInfoError("Calificacion modificada exitosamente!");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}else {
			response.setErrorCode(400);
			response.setInfoError("Calificacion no modificada por error en la base de datos");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
		  //Manejo de excepciones generales
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setErrorCode(400);
			response.setInfoError("La calificacion no se pudó modificar ");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

	}

}
