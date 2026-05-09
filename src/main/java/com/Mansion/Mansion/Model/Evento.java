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
@Table(name = "EVENTO")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    @ManyToOne
    @JoinColumn(name = "id_eventos")
    private Eventos tipoEvento; /* esto conecta evento con EVENTOS */

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion; /* En que habitación está sucediendo */

    private String descripcionEspecifica;

    private boolean completado;
}
