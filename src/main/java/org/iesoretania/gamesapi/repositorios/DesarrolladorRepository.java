package org.iesoretania.gamesapi.repositorios;

import org.iesoretania.gamesapi.entidades.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
}