package org.iesoretania.gamesapi.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Juegos")
public class Juego {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "titulo")
    private String titulo;

    @Basic
    @Column(name = "genero")
    private String genero;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic
    @Column(name = "lanzamiento")
    private Date lanzamiento;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "desarrollador_id")
    private Desarrollador desarrollador;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "plataforma_id")
    private Plataforma plataforma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Date lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
}
