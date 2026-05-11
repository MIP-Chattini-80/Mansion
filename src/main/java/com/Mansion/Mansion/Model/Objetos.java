package com.Mansion.Mansion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.Mansion.Mansion.DTO.ObjetosDTO;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OBJETOS")
public class Objetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstancia;

    @ManyToOne
    @JoinColumn(name = "id_objeto")
    private Objeto OBJETObASE;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion ubicacion;

    @NotBlank(message = "El estado del objeto (ej: Activo) es obligatorio")
    private String estado;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad;

    public ObjetosDTO convertirADTO() {

        ObjetosDTO dto = new ObjetosDTO();

        dto.setIdInstancia(this.idInstancia);

        if (this.OBJETObASE != null) {
            dto.setNombreObjeto(this.OBJETObASE.getNombre());
        }

        if (this.ubicacion != null) {
            dto.setNombreHabitacion(this.ubicacion.getNombre());
        }

        dto.setEstado(this.estado);
        dto.setCantidad(this.cantidad);

        return dto;
    }

    public Object getIdObjeto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdObjeto'");
    }

}