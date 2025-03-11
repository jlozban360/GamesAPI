package org.iesoretania.gamesapi.controladores;

import org.iesoretania.gamesapi.entidades.Plataforma;
import org.iesoretania.gamesapi.repositorios.PlataformaRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    private final PlataformaRepository plataformaRepository;

    public PlataformaController(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    @GetMapping
    public List<Plataforma> getAllPlataformas() {
        return (List<Plataforma>) plataformaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Plataforma> getPlataformaById(@PathVariable Long id) {
        return plataformaRepository.findById(id);
    }

    @PostMapping
    public Plataforma createPlataforma(@RequestBody Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    @PutMapping("/{id}")
    public Plataforma updatePlataforma(@PathVariable Long id, @RequestBody Plataforma plataformaDetails) {
        Plataforma plataforma = plataformaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plataforma no encontrada"));
        plataforma.setNombre(plataformaDetails.getNombre());
        return plataformaRepository.save(plataforma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlataforma(@PathVariable Long id) {
        Plataforma plataforma = plataformaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plataforma no encontrada"));
        plataformaRepository.delete(plataforma);
        return ResponseEntity.ok().build();
    }
}