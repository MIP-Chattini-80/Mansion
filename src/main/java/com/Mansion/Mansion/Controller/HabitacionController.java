package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.DTO.HabitacionDTO;
import com.Mansion.Mansion.Model.Habitacion;
import com.Mansion.Mansion.Service.HabitacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/{id}")
    public List<HabitacionDTO> listar() {
        return habitacionService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> obtener(@PathVariable Long id) {
        HabitacionDTO dto = habitacionService.obtenerPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HabitacionDTO> crear(@Valid @RequestBody Habitacion habitacion) {
        return ResponseEntity.ok(habitacionService.guardar(habitacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDTO> actualizar(@PathVariable Long id, @Valid @RequestBody Habitacion habitacion) {
        HabitacionDTO actualizado = habitacionService.actualizar(id, habitacion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        habitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}