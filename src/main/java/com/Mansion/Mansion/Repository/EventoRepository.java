package com.Mansion.Mansion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mansion.Mansion.Model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
