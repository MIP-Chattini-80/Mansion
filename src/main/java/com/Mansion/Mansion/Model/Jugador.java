package com.Mansion.Mansion.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.Mansion.Mansion.DTO.JugadorDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JUGADOR")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJugador;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    public JugadorDTO convertirADTO() {

    JugadorDTO dto = new JugadorDTO();

    dto.setIdJugador(this.idJugador);
    dto.setUsername(this.username);
    dto.setEmail(this.email);

    return dto;
}

}
