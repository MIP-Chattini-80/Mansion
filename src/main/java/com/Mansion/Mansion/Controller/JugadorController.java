package com.Mansion.Mansion.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mansion.Mansion.DTO.JugadorDTO;
import com.Mansion.Mansion.Model.Jugador;
import com.Mansion.Mansion.Service.JugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public ResponseEntity<List<JugadorDTO>> listar() {

        List<Jugador> jugadores = jugadorService.listar();

        List<JugadorDTO> listaDTO = new ArrayList<>();

        for (Jugador jugador : jugadores) {
            listaDTO.add(jugador.convertirADTO());
        }

        return ResponseEntity.ok(listaDTO);
    }

}