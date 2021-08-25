package com.examenike.demo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examenike.demo.dto.EstudianteDTO;
import com.examenike.demo.dto.MateriaDTO;
import com.examenike.demo.helperbean.RequestCalificacion;
import com.examenike.demo.helperbean.RequestEstudiante;
import com.examenike.demo.helperbean.Response;
import com.examenike.demo.modelo.CalificacionModelo;
import com.examenike.demo.modelo.EstudianteModelo;
import com.examenike.demo.modelo.MateriaModelo;
import com.examenike.demo.repositorios.CalificacionRepositorio;
import com.examenike.demo.repositorios.EstudianteRepositorio;
import com.examenike.demo.repositorios.MateriaRepositorio;

@Service
public class EstudianteServicio {

	//Inyeccion de dependencias
	@Autowired
	EstudianteRepositorio estudianteRepositorio;

	@Autowired
	MateriaRepositorio materiaRepositorio;

	@Autowired
	CalificacionRepositorio calificacionRepositorio;

	
	/**
	 * Metodo que genera una cadena de 12 caracteres de manera aleatoria de la "A" hasta la "Z" con el fin de suplir el dato de la matricula
	 * @return cadena
	 */
	private String Matricula() {
		String cadena = "";
		for (int i = 1; i <= 12; i++) {
			int num = (int) ((Math.random() * (('Z' - 'A') + 1)) + 'A');
			char letra = (char) num;
			cadena = cadena + letra;
		}
		return cadena;
	}

	/**
	 * Metodo que permite consultar todos los estudiantes matriculados
	 * @return response
	 */
	public ResponseEntity<Response> consultarEstudiante() {
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		//Se crean dos listas de tipo EstudianteModelo y RequestEstudiante, la primera para traer los estudiantes y la segunda para 
		//hacer uso de dos atributos esenciales para la construcción de la consulta como la entidad/modelo estudiante y un array de materias
		List<EstudianteModelo> estudianteModelo = new ArrayList<EstudianteModelo>();
		List<RequestEstudiante> consultaLista = new ArrayList<RequestEstudiante>();
		try {
			//consulta de todos los estudiantes
			estudianteModelo = estudianteRepositorio.findAll();
			//Se usa un ciclo for con el fin de recorrer los estudiantes registrados
			for (EstudianteModelo recorrerListEstudiante : estudianteModelo) {
				//Por cada estudiante se crea un objeto de tipo RequestEstudiante para cargar los atributos que nos da este objeto
				RequestEstudiante listaCargada = new RequestEstudiante();
				//Se crearan ademas dos listas  de las entidades/modelo calificacion y materia
				List<CalificacionModelo> calificacionModelo = new ArrayList<CalificacionModelo>();
				List<MateriaModelo> materiaModelo = new ArrayList<MateriaModelo>();
				//Se realiza una consulta con filtro por id de estudiante y se recorre 
				calificacionModelo = calificacionRepositorio
						.findByIdEstudiante(recorrerListEstudiante.getId_estudiante());
				//se recorre las materias por estudiante y se añade a una lista este atributo materia
				for (CalificacionModelo recorrerListMateria : calificacionModelo) {
					materiaModelo.add(recorrerListMateria.getMateria());
				}
				listaCargada.setEstudianteModelo(recorrerListEstudiante);
				listaCargada.setMateriaModelo(materiaModelo);
				//finalmente se carga la lista ya completa con los estudiantes y las materias
				consultaLista.add(listaCargada);
			}
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(001);
			response.setInfoError(consultaLista);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			//manejo de excepciones generales
		} catch (Exception ex) {
			response.setErrorCode(404);
			response.setInfoError(ex.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	
	/**
	 * Metodo que permite consultar todos los estudiantes matriculados con sus respetivas calificaciones
	 * @return response
	 */
	public ResponseEntity<Response> consultarCalificacionEstudiante() {
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		List<EstudianteModelo> estudianteModelo = new ArrayList<EstudianteModelo>();
		List<RequestCalificacion> requestCalificacion = new ArrayList<RequestCalificacion>();
		try {
			estudianteModelo = estudianteRepositorio.findAll();

			for (EstudianteModelo recorrerListEstudiante : estudianteModelo) {
				RequestCalificacion consultaCalificacion = new RequestCalificacion();
				List<CalificacionModelo> calificacionModelo = new ArrayList<CalificacionModelo>();
				List<MateriaDTO> materiadto = new ArrayList<MateriaDTO>();

				calificacionModelo = calificacionRepositorio
						.findByIdEstudiante(recorrerListEstudiante.getId_estudiante());
				for (CalificacionModelo calificacionConsultaMateria : calificacionModelo) {
					MateriaDTO materiaCalificacion = new MateriaDTO();
					materiaCalificacion.setId_materia(calificacionConsultaMateria.getMateria().getId_materia());
					materiaCalificacion.setNombre(calificacionConsultaMateria.getMateria().getNombreMateria());
					//hay dos diferencias respecto al metodo de consulta basico y es que aqui se obtiene el valor de la calificacion
					//y una lista de tipo Calificacion en donde esta vez se guarda estudiantes con su materia y su respectiva calificacion
					//por materia
					materiaCalificacion.setCalificacion(calificacionConsultaMateria.getValor());

					materiadto.add(materiaCalificacion);
				}
				consultaCalificacion.setEstudianteModelo(recorrerListEstudiante);
				consultaCalificacion.setMateriadto(materiadto);

				requestCalificacion.add(consultaCalificacion);
			}
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(001);
			response.setInfoError(requestCalificacion);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			//manejo de excepciones generales
		} catch (Exception e) {
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(404);
			response.setInfoError(e.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Metodo que permite registrar estudiantes
	 * @param estudiantedto
	 * @return response
	 */
	public ResponseEntity<Response> registrarEstudiante(EstudianteDTO estudiantedto) {
		//Creación de objeto response para el manejo de las respuestas de los servicios
		Response response = new Response();
		//Creación de dos objetos EstudianteModelo con el objetivo de acceder a sus atributos y obtenerlos o mandarles valores
		EstudianteModelo estudianteModelo = new EstudianteModelo();
		EstudianteModelo saveObjEstudiante = new EstudianteModelo();
		//objeto de tipo opcional en donde si nos trae datos es true de lo contrario false
		Optional<MateriaModelo> materiaModelo;

		try { 
			//uso de los metodos de acceso para su inserción de datos
			estudianteModelo.setApellidoMaterno(estudiantedto.getApellidoMaterno());
			estudianteModelo.setApellidoPaterno(estudiantedto.getApellidoPaterno());
			estudianteModelo.setNombre(estudiantedto.getNombre());
			estudianteModelo.setMatricula(Matricula());
			//Se llaama el repositorio para hacer uso de un metodo CRUD que es save y lo guardamos en el objeto estudianteModelo
			saveObjEstudiante = estudianteRepositorio.save(estudianteModelo);
			//Se realiza un ciclo for para que recorra y registre todas las materias registradas a un id estudiante 
			//por cada dato que se le mande en "materia"
			for (int i = 0; i < estudiantedto.getMateria().length; i++) {
				CalificacionModelo calificacionModelo = new CalificacionModelo();
				materiaModelo = materiaRepositorio.findById(estudiantedto.getMateria()[i]);
				//validacion que dice en caso de que el objeto opcional este vacio este indicara que se estará registrando una materia con 
				//id inexistente
				if (materiaModelo.isEmpty()) {
					//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
					response.setErrorCode(404);
					response.setInfoError("Por favor ingrese un identificador de materia existente");
					return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
				} else {
					calificacionModelo.setEstudiante(saveObjEstudiante);
					calificacionModelo.setMateria(materiaModelo.get());
					calificacionRepositorio.save(calificacionModelo);
				}
			}
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(001);
			response.setInfoError("Estudiante registrado");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
			//manejo de excepciones generales
		} catch (Exception ex) {
			//se setean los mensajes y codigos exitosos y no exitosos dependiendo la respuesta ya sea OK o BAD_REQUEST
			response.setErrorCode(001);
			response.setInfoError(ex.getMessage());
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

	}



}
