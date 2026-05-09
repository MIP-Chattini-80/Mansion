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
@Table(name = "OBJETOS")
public class Objetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstancia; /* id_instancia es el que permite distinguir entre dos cosas que son iguales en definición pero diferentes en existencia.  */

    @ManyToOne
    @JoinColumn(name = "id_objeto")
    private Objeto OBJETObASE;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion ubicacion;

    private String estado;

    private Integer cantidad;
}