package com.Mansion.Mansion.Repository;

import com.Mansion.Mansion.Model.Objetos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetosRepository extends JpaRepository<Objetos, Long> {
    
}