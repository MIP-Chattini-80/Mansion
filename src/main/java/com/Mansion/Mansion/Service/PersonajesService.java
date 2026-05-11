package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.Model.Personajes;
import com.Mansion.Mansion.Repository.PersonajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajesService {

    @Autowired
    private PersonajesRepository personajesRepository;

    public List<Personajes> listarTodos() {
        return personajesRepository.findAll();
    }

    public Optional<Personajes> obtenerPorId(Long id) {
        return personajesRepository.findById(id);
    }

    public Personajes guardar(Personajes personajes) {
        return personajesRepository.save(personajes);
    }

    public Personajes actualizar(Long id, Personajes datosNuevos) {
        return personajesRepository.findById(id).map(categoria -> {
            categoria.setCategoriaOrigen(datosNuevos.getCategoriaOrigen());
            return personajesRepository.save(categoria);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        personajesRepository.deleteById(id);
    }
    
}