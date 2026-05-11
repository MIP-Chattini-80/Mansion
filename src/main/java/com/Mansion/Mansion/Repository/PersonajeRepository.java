package com.Mansion.Mansion.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Mansion.Mansion.Model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

    List<Personaje> findBySerie(String serie);

    @Query("SELECT p FROM Personaje p JOIN p.habitacion h WHERE h.nombre = :nombreHabitacion") /*personajes que están en una habitación específica */
    List<Personaje> buscarPorNombreDeHabitacion(@Param("nombreHabitacion") String nombreHabitacion);

}