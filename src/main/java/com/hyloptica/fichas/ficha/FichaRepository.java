package com.hyloptica.fichas.ficha;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {
    
    Optional<Ficha> findFichaByNombreAndApellido(String name, String apellido);


}