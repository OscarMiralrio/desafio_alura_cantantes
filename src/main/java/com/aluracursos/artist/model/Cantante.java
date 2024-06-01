package com.aluracursos.artist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cantantes")
public class Cantante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombreCompleto;
    private String nombreArtistico;
    private LocalDate fechaDeNacimiento;
    private String lugarDeNacimiento;
    private String nacionalidad;

    @OneToMany(mappedBy = "cantante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> albums;

    public Cantante(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        albums.forEach( a -> a.setCantante(this));
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", nombreArtistico='" + nombreArtistico + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", lugarDeNacimiento='" + lugarDeNacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", albums=" + albums +
                '}';
    }
}
