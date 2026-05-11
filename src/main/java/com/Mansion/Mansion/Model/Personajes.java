package com.Mansion.Mansion.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAJES")
public class Personajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonajes; /* Este id es el que guarda las categorías de cada personaje, es decir, si hay 10 vtuber o personajes de peli, cone ste id se  */

    @NotBlank(message = "La categoría de origen es obligatoria")
    @Column(name = "categoria_origen")
    private String categoriaOrigen;
    
}
