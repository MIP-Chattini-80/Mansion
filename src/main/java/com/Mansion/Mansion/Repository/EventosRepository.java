package com.Mansion.Mansion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mansion.Mansion.Model.Eventos;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {
    
}
