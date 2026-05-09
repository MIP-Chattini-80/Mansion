package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROGRESO")
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgreso;
    
    @OneToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    private int nivelActual;

    private int puntosExperiencia;

    @ManyToOne
    @JoinColumn(name = "id_habitacion_actual")
    private Habitacion habitacionActual;
}