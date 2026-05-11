package com.Mansion.Mansion.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mansion.Mansion.DTO.HabitacionDTO;
import com.Mansion.Mansion.Model.Habitacion;
import com.Mansion.Mansion.Repository.HabitacionRepository;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<HabitacionDTO> listarTodas() {
        return habitacionRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public HabitacionDTO obtenerPorId(Long id) {
        return habitacionRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    private HabitacionDTO mapToDTO(Habitacion habitacion) {
        HabitacionDTO dto = new HabitacionDTO();
        dto.setIdHabitacion(habitacion.getIdHabitacion());
        dto.setNombre(habitacion.getNombre());
        dto.setDescripcion(habitacion.getDescripcion());
        dto.setEsZonaSegura(habitacion.isEsZonaSegura());
        return dto;
    }

    public HabitacionDTO guardar(Habitacion habitacion) {
        Habitacion guardada = habitacionRepository.save(habitacion);
        return mapToDTO(guardada);
    }

    public HabitacionDTO actualizar(Long id, Habitacion datosNuevos) {
        return habitacionRepository.findById(id).map(habitacion -> {
            habitacion.setNombre(datosNuevos.getNombre());
            habitacion.setDescripcion(datosNuevos.getDescripcion());
            habitacion.setEsZonaSegura(datosNuevos.isEsZonaSegura());
            Habitacion actualizada = habitacionRepository.save(habitacion);
            return mapToDTO(actualizada);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        habitacionRepository.deleteById(id);
    }


}