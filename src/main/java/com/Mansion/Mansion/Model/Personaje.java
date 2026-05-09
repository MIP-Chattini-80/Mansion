package com.Mansion.Mansion.Model;

import jakarta.persistence.Column;
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
@Table(name= "Personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonaje;

    private String nombre;

    @Column(name = "Serie_Procedencia")
    private String serie; /* De donde viene, serie, peli, vtuber, videojuego, franquicia */

    @ManyToOne
    @JoinColumn(name = "id_personajes")
    private Personajes tipoOrigen; /* Aqui esto conecta a Personaje con PERSONAJES */

}