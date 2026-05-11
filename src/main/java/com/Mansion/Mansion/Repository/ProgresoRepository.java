package com.Mansion.Mansion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mansion.Mansion.Model.Progreso;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
}
