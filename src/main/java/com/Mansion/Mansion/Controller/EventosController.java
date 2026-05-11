package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.Model.Eventos;
import com.Mansion.Mansion.Service.EventosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @GetMapping
    public List<Eventos> listar() {
        return eventosService.listarCategorias();
    }

    @PostMapping
    public Eventos crear(@Valid @RequestBody Eventos eventos) {
        return eventosService.guardarCategoria(eventos);
    }
}