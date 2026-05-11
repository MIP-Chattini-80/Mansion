package com.Mansion.Mansion.Repository;

import com.Mansion.Mansion.Model.Personajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajesRepository extends JpaRepository<Personajes, Long> {

}







