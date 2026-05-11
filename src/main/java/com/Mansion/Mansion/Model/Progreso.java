package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    
    @NotNull(message = "El progreso debe estar asociado a un jugador")
    @OneToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @Min(value = 1, message = "El nivel mínimo es 1")
    private int nivelActual;

    @Min(value = 0, message = "La experiencia no puede ser negativa")
    private int puntosExperiencia;

    @NotNull(message = "Se debe registrar en qué habitación se encuentra el jugador")
    @ManyToOne
    @JoinColumn(name = "id_habitacion_actual")
    private Habitacion habitacionActual;
}