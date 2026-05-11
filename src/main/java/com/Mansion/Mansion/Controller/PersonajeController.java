package com.Mansion.Mansion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mansion.Mansion.DTO.PersonajeDTO;
import com.Mansion.Mansion.Model.Personaje;
import com.Mansion.Mansion.Service.PersonajeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<PersonajeDTO> listar() {
        return personajeService.obtenerTodos();
    }

    @PostMapping
    public Personaje crear(@Valid @RequestBody Personaje personaje) {
        return personajeService.guardarPersonaje(personaje);
    }

    @PutMapping("/{id}")
    public Personaje actualizar(@PathVariable Long id,
        @RequestBody Personaje personaje) {
            personaje.setIdPersonaje(id);
            return personajeService.guardarPersonaje(personaje);
        }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        personajeService.eliminar(id);
        return "Personaje eliminado correctamente";
    }
}