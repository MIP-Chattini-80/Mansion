package com.Mansion.Mansion.Model;

import com.Mansion.Mansion.DTO.PersonajeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personaje")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Long idPersonaje;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 2, max = 100)
    private String nombre;

    @NotBlank(message = "Debes indicar de donde proviene")
    @Column(name = "serie_procedencia")
    private String serie;

    @ManyToOne
    @JoinColumn(name = "id_personajes")
    private Personajes tipoOrigen;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    @NotNull(message = "El personaje debe estar asignado a una habitación")
    private Habitacion habitacion;

    public PersonajeDTO convertirADTO() {

        PersonajeDTO dto = new PersonajeDTO();

        dto.setIdPersonaje(this.idPersonaje);
        dto.setNombre(this.nombre);
        dto.setSerie(this.serie);

        return dto;
    }
}