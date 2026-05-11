package com.Mansion.Mansion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mansion.Mansion.DTO.PersonajeDTO;
import com.Mansion.Mansion.Model.Personaje;
import com.Mansion.Mansion.Repository.PersonajeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<PersonajeDTO> obtenerTodos() {
        return personajeRepository.findAll().stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    public Personaje buscarPorId(Long id) {
        return personajeRepository.findById(id).orElseThrow(() -> new RuntimeException("¡Personaje no encontrado en la mansión!"));
    }

    public Personaje guardarPersonaje(Personaje perso) {
        return personajeRepository.save(perso);
    }

    public void eliminar(Long id) {
        if (!personajeRepository.existsById(id)) {
        throw new RuntimeException("El personaje no existe");
    }

personajeRepository.deleteById(id);
    }

    public List<PersonajeDTO> buscarPorSerie(String serie){
        return personajeRepository.findBySerie(serie).stream()
                 .map(this::convertirADTO)
                 .toList();
    }

    private PersonajeDTO convertirADTO(Personaje personaje) {
        PersonajeDTO dto = new PersonajeDTO();
        
        dto.setIdPersonaje(personaje.getIdPersonaje());
        dto.setNombre(personaje.getNombre());
        
        if (personaje.getSerie() != null) {
            dto.setSerie(personaje.getSerie());
        } else {
            dto.setSerie("Sin Serie");
        }
        return dto;
    }

}