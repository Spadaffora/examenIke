package com.examenike.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenike.demo.modelo.MateriaModelo;

@Repository
public interface MateriaRepositorio extends JpaRepository<MateriaModelo, Integer> {

}
