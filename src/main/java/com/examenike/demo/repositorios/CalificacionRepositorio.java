package com.examenike.demo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examenike.demo.modelo.CalificacionModelo;


//extends JpaRepository para el uso de metodos CRUD dentro del modelo/entidad Calificacion
@Repository
@Transactional
public interface CalificacionRepositorio extends JpaRepository<CalificacionModelo, Integer> {

	/**
	 * Consulta nativa a la tabla calificaciones pasandole como parametro
	 * @param id_estudiante
	 * @return none
	 */
	@Query(value = "SELECT * FROM calificaciones WHERE estudiante = ?1", nativeQuery = true)
	List<CalificacionModelo> findByIdEstudiante(int id_estudiante);

	
	/**
	 * Consulta nativa a la tabla calificaciones pasandole como filtro los parametros
	 * @param calificacion
	 * @param id_Estudiante
	 * @param id_Materia
	 * @return none
	 */
	@Modifying
	@Query(value = "UPDATE calificaciones SET valor = ?1 WHERE estudiante = ?2 AND materia = ?3", nativeQuery = true)
	Integer actulizarCalificacion(int calificacion, int id_Estudiante, int id_Materia);

	
	/**
	 * Consulta nativa a la tabla calificaciones pasandole como filtro los parametros
	 * @param id_Estudiante
	 * @param id_Materia
	 * @return none
	 */
	@Modifying
	@Query(value = "UPDATE calificaciones SET valor = null WHERE estudiante = ?1 AND materia = ?2", nativeQuery = true)
	Integer eliminarCalificacion(int id_Estudiante, int id_Materia);

}
