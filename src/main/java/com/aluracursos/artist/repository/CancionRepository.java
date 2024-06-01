package com.aluracursos.artist.repository;

import com.aluracursos.artist.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
}
