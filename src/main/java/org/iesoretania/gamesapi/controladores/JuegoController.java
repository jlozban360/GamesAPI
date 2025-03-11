package org.iesoretania.gamesapi.controladores;

import org.iesoretania.gamesapi.entidades.Juego;
import org.iesoretania.gamesapi.repositorios.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    @Autowired
    private JuegoRepository juegoRepository;

    @GetMapping
    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }

    @PostMapping
    public Juego createJuego(@RequestBody Juego juego) {
        return juegoRepository.save(juego);
    }

    @GetMapping("/{id}")
    public Juego getJuegoById(@PathVariable Long id) {
        return juegoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado"));
    }

    @PutMapping("/{id}")
    public Juego updateJuego(@PathVariable Long id, @RequestBody Juego juegoDetails) {
        Juego juego = juegoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado"));
        juego.setTitulo(juegoDetails.getTitulo());
        juego.setGenero(juegoDetails.getGenero());
        juego.setLanzamiento(juegoDetails.getLanzamiento());
        return juegoRepository.save(juego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJuego(@PathVariable Long id) {
        Juego juego = juegoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado"));
        juegoRepository.delete(juego);
        return ResponseEntity.ok().build();
    }
}