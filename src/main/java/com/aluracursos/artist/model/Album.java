package com.aluracursos.artist.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idCantante;
    private String titulo;
    private String discografica;
    private String genero;

    @ManyToOne
    private Cantante cantante;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancion> canciones;

    public Album() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCantante() {
        return idCantante;
    }

    public void setIdCantante(Integer idCantante) {
        this.idCantante = idCantante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        canciones.forEach( c -> c.setAlbum(this));
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", idCantante=" + idCantante +
                ", titulo='" + titulo + '\'' +
                ", discografica='" + discografica + '\'' +
                ", genero='" + genero + '\'' +
                ", cantante=" + cantante +
                ", canciones=" + canciones +
                '}';
    }
}
