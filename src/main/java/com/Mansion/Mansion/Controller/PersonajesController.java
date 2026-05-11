package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.Model.Personajes;
import com.Mansion.Mansion.Service.PersonajesService;
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
@RequestMapping("/api/categorias-personajes")
public class PersonajesController {

    @Autowired
    private PersonajesService personajesService;

    @GetMapping
    public List<Personajes> listar() {
        return personajesService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personajes> obtener(@PathVariable Long id) {
        return personajesService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Personajes crear(@Valid @RequestBody Personajes personajes) {
        return personajesService.guardarPersonajes(personajes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personajes> actualizar(@PathVariable Long id, @Valid @RequestBody Personajes personajes) {
        Personajes actualizado = personajesService.actualizarPersonajes(id, personajes);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personajesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}