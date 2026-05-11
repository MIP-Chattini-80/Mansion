package com.Mansion.Mansion.Repository;

import com.Mansion.Mansion.Model.Puerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuertaRepository extends JpaRepository<Puerta, Long> {

}
