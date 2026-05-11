package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.DTO.EventoDTO;
import com.Mansion.Mansion.Model.Evento;
import com.Mansion.Mansion.Service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoDTO> listar() {
        return eventoService.listarEventosDTO();
    }

    @PostMapping
    public ResponseEntity<Evento> crear(@Valid @RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.guardarEvento(evento));
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<EventoDTO> completar(@PathVariable Long id) {
        EventoDTO dto = eventoService.completarEvento(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}