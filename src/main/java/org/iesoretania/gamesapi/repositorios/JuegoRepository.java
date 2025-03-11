package org.iesoretania.gamesapi.repositorios;

import org.iesoretania.gamesapi.entidades.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
}
