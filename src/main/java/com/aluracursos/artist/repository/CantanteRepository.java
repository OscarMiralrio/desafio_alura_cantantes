package com.aluracursos.artist.repository;

import com.aluracursos.artist.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CantanteRepository extends JpaRepository<Cantante, Long> {

    Optional<Cantante> findByNombreCompletoContainingIgnoreCase(String nombre);

}
