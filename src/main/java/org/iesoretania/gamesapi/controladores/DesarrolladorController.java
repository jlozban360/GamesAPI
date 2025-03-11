package org.iesoretania.gamesapi.controladores;

import org.iesoretania.gamesapi.entidades.Desarrollador;
import org.iesoretania.gamesapi.repositorios.DesarrolladorRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/desarrolladores")
public class DesarrolladorController {

    private final DesarrolladorRepository desarrolladorRepository;

    public DesarrolladorController(DesarrolladorRepository desarrolladorRepository) {
        this.desarrolladorRepository = desarrolladorRepository;
    }

    @GetMapping
    public List<Desarrollador> getAllDesarrolladores() {
        return (List<Desarrollador>) desarrolladorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Desarrollador> getDesarrolladorById(@PathVariable Long id) {
        return desarrolladorRepository.findById(id);
    }

    @PostMapping
    public Desarrollador createDesarrollador(@RequestBody Desarrollador desarrollador) {
        return desarrolladorRepository.save(desarrollador);
    }

    @PutMapping("/{id}")
    public Desarrollador updateDesarrollador(@PathVariable Long id, @RequestBody Desarrollador desarrolladorDetails) {
        Desarrollador desarrollador = desarrolladorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Desarrollador no encontrado"));
        desarrollador.setNombre(desarrolladorDetails.getNombre());
        desarrollador.setPais(desarrolladorDetails.getPais());
        return desarrolladorRepository.save(desarrollador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDesarrollador(@PathVariable Long id) {
        Desarrollador desarrollador = desarrolladorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Desarrollador no encontrado"));
        desarrolladorRepository.delete(desarrollador);
        return ResponseEntity.ok().build();
    }
}