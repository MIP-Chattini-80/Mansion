package com.Mansion.Mansion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Model.Objeto;
import com.Mansion.Mansion.Repository.ObjetoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjetoService {

    @Autowired
    private ObjetoRepository objetoRepository;

    public List<ObjetosDTO> listarTodo() {
        return objetoRepository.findAll().stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    private ObjetosDTO mapToDTO(Objeto modelo) {
        ObjetosDTO dto = new ObjetosDTO();
        dto.setIdObjeto(modelo.getIdObjeto());
        dto.setNombreObjeto(null); 
        
        return dto;
    }
}