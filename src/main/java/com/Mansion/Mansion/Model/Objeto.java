package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private String nombre;

    private String descripcion;

    private String tipoObjeto; /* Que tipo de objeto es, cortopunzante, item de busqueda, etc. */
    
    private Integer valorBase; /* Cuanto vale ese objeto en términos de valor de uso, inutil, valioso, necesario, herramienta para más tarde */
}