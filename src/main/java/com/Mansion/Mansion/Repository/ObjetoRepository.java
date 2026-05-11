package com.Mansion.Mansion.Repository;

import com.Mansion.Mansion.Model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetoRepository extends JpaRepository<Objeto, Long> {
    
}