package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.Model.Puerta;
import com.Mansion.Mansion.Service.PuertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puertas")
public class PuertaController {

    @Autowired
    private PuertaService puertaService;

    @GetMapping
    public List<Puerta> listar() {
        return puertaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puerta> obtener(@PathVariable Long id) {
        return puertaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Puerta crear(@Valid @RequestBody Puerta puerta) {
        return puertaService.guardar(puerta);
    }

    @PutMapping("/{id}/bloqueo")
    public ResponseEntity<Puerta> actualizarBloqueo(@PathVariable Long id, @RequestParam boolean bloqueada) {
        Puerta actualizada = puertaService.cambiarBloqueo(id, bloqueada);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        puertaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}