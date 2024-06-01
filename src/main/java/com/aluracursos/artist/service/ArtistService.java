package com.aluracursos.artist.service;

import com.aluracursos.artist.model.Album;
import com.aluracursos.artist.model.Cancion;
import com.aluracursos.artist.model.Cantante;
import com.aluracursos.artist.repository.AlbumRepository;
import com.aluracursos.artist.repository.CancionRepository;
import com.aluracursos.artist.repository.CantanteRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import static com.aluracursos.artist.util.Util.*;

public class ArtistService {

    private Scanner teclado = new Scanner(System.in);

    private final CantanteRepository cantanteRepository;
    private final AlbumRepository albumRepository;
    private final CancionRepository cancionRepository;

    public ArtistService(CantanteRepository cantanteRepository, AlbumRepository albumRepository, CancionRepository cancionRepository) {
        this.cantanteRepository = cantanteRepository;
        this.albumRepository = albumRepository;
        this.cancionRepository = cancionRepository;

    }

    public void principal(){

        var opcion = -1;
        var menu = """
                ************************************
                1 - Registrar Datos de Cantantes.
                2 - Registrar Datos de Albums.
                3 - Registrar Datos de Canciones.
                4 - Mostrar canciones.
                5 - Mostrar albums.
                6 - Mostrar cantantes.
                
                0 - Salir.
                ************************************
                """;

        while(opcion != 0){
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException e){
                System.out.println(" :: Opcion Invalida :: ");
                teclado.nextLine();
                continue;
            }
            teclado.nextLine();

            switch (opcion){
                case 1:
                    registrarCantante();
                    break;
                case 2:
                    registraAlbum();
                    break;
                case 3:
                    registraCancion();
                    break;
                case 4:
                    mostrarCanciones();
                    break;
                case 5:
                    mostrarAlbums();
                    break;
                case 6:
                    mostrarCantantes();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

    private void registrarCantante(){
        var registrarNuevoCantante = "S";
        Cantante cantante;
        while (registrarNuevoCantante.equalsIgnoreCase("s")){
            cantante = new Cantante(
                    nombreValidado(),
                    nombreArtisticoValidado(),
                    fechaDeNacimientoValidada(),
                    lugarDeNacimientoValidado(),
                    nacionalidadValidado()
            );
            cantanteRepository.save(cantante);
            System.out.println("¿Deseas registrar un nuevo cantante ? (S/N)");
            registrarNuevoCantante = teclado.nextLine();
        }
    }

    private void registraAlbum(){
        System.out.println("Ingresa el nombre del cantante al que desea agregar un album");
        var nombreCantante = teclado.nextLine();
        Optional<Cantante> cantante = cantanteRepository.findByNombreCompletoContainingIgnoreCase(nombreCantante);
        if (cantante.isPresent()){

            System.out.println("Ingresa el nombre del album");
            var nombreAlbum = teclado.nextLine();

            System.out.println("Ingresa el nombre de la discografia.");
            var nombreDiscografia = teclado.nextLine();

            System.out.println("Ingresa el genero del album");
            var genero = teclado.nextLine();

            Album album = new Album(nombreAlbum,nombreDiscografia,genero);
            album.setCantante(cantante.get());
            cantante.get().getAlbums().add(album);

            albumRepository.save(album);

        } else {
            System.out.println(" :: Cantante no encontrado :: ");
        }
    }

    public void registraCancion(){

        System.out.println("Ingresa el nombre del album al que deseas agregar canciones: ");
        var nombreAlbum = teclado.nextLine();
        Optional<Album> album = albumRepository.obtieneAlbum(nombreAlbum);

        if (album.isPresent()){
            System.out.println("Ingresa el titulo de la cancion");
            var nombreCancion = teclado.nextLine();

            System.out.println("Ingresa la duración de la cancion en el siguiente formato 00:00:00");
            var duracion = teclado.nextLine();

            System.out.println("Ingresa el nombre del compositor de la cancion");
            var compositor = teclado.nextLine();

            System.out.println("Ingresa el nombre del productor de la cancion");
            var productor = teclado.nextLine();

            Cancion cancion = new Cancion(
              nombreCancion,
              duracion,
              compositor,
              productor
            );

            cancion.setAlbum(album.get());
            album.get().getCanciones().add(cancion);

            cancionRepository.save(cancion);

        }else {
            System.out.println(" :: Album no encontrado :: ");
        }
    }
    private void mostrarCanciones(){
        List<Cancion> cancionesList = cancionRepository.findAll();
        cancionesList.forEach(System.out::println);
    }
    private void mostrarAlbums(){
        List<Album> albumList = albumRepository.findAll();
        albumList.forEach(System.out::println);
    }
    private void mostrarCantantes(){
        List<Cantante> cantanteList = cantanteRepository.findAll();
        cantanteList.forEach(System.out::println);
    }

}
