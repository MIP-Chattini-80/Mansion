package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.Model.Progreso;
import com.Mansion.Mansion.Service.ProgresoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progreso")
public class ProgresoController {

    @Autowired
    private ProgresoService progresoService;

    @GetMapping
    public List<Progreso> listar() {
        return progresoService.listarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> obtener(@PathVariable Long id) {
        return progresoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Progreso> crear(@Valid @RequestBody Progreso progreso) {
        return ResponseEntity.ok(progresoService.guardar(progreso));
    }

    @PutMapping("/{id}/experiencia")
    public ResponseEntity<Progreso> actualizarExp(@PathVariable Long id, @RequestParam int exp) {
        Progreso actualizado = progresoService.actualizarExperiencia(id, exp);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        progresoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}