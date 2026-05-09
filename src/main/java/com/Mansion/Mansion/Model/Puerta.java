package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PUERTA")
public class Puerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuerta;

    @ManyToOne
    @JoinColumn(name = "id_habitacion_origen")
    private Habitacion origen;

    @ManyToOne
    @JoinColumn(name = "id_habitacion_destino")
    private Habitacion destino;

    private boolean estaBloqueada;
}