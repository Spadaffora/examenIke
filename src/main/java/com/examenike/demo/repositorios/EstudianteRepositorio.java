package com.examenike.demo.repositorios;

import com.examenike.demo.modelo.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<EstudianteModelo, Integer> {

	List<EstudianteModelo> findByNombre(String nombre);

	List<EstudianteModelo> findByMatricula(String matricula);

}
