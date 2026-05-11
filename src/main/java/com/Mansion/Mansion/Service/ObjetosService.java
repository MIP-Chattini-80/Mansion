package com.Mansion.Mansion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Model.Objetos;
import com.Mansion.Mansion.Repository.ObjetosRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjetosService {

    @Autowired
    private ObjetosRepository objetosRepository;

    public List<ObjetosDTO> listarInstancias() {
        return objetosRepository.findAll().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    private ObjetosDTO mapToDTO(Objetos modelo) {
        ObjetosDTO dto = new ObjetosDTO();
        dto.setIdObjeto(null);
        dto.setNombreObjeto(modelo.getEstado());
        
        return dto;
    }
}