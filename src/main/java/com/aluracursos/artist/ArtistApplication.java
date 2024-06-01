package com.aluracursos.artist;

import com.aluracursos.artist.repository.AlbumRepository;
import com.aluracursos.artist.repository.CancionRepository;
import com.aluracursos.artist.repository.CantanteRepository;
import com.aluracursos.artist.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ArtistApplication implements CommandLineRunner {

	@Autowired
	private CantanteRepository cantanteRepository;
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private CancionRepository cancionRepository;

	public static void main(String[] args) {
		SpringApplication.run(ArtistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ArtistService service = new ArtistService(cantanteRepository,albumRepository,cancionRepository);
		service.principal();

	}
}
