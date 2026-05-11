package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.DTO.EventoDTO;
import com.Mansion.Mansion.Model.Evento;
import com.Mansion.Mansion.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoDTO> listarEventosDTO() {
        return eventoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Evento guardarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public EventoDTO completarEvento(Long id) {
        return eventoRepository.findById(id).map(evento -> {
            evento.setCompletado(true);
            return mapToDTO(eventoRepository.save(evento));
        }).orElse(null);
    }

    private EventoDTO mapToDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();
        dto.setIdEvento(evento.getIdEvento());
        dto.setDescripcionEspecifica(evento.getDescripcionEspecifica());
        dto.setCompletado(evento.isCompletado());
        return dto;
    }
}