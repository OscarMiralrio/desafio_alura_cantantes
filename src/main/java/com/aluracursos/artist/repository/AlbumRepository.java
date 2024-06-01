package com.aluracursos.artist.repository;

import com.aluracursos.artist.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Cantante c JOIN c.albums a WHERE a.titulo ILIKE %:titulo%")
    Optional<Album> obtieneAlbum(String titulo);

}
