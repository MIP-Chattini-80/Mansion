package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Objeto")
public class Objeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjeto;

    @NotBlank(message = "El nombre del objeto es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripción es necesaria")
    private String descripcion;

    @NotBlank(message = "Categoría de objeto obligatoria")
    private String tipoObjeto; /* Que tipo de objeto es, cortopunzante, item de busqueda, etc. */
    
    @NotNull(message = "El valor base debe ser definido")
    @Min(value = 0, message = "El valor base no puede ser negativo")
    private Integer valorBase; /* Cuanto vale ese objeto en términos de valor de uso, inutil, valioso, necesario, herramienta para más tarde */

}