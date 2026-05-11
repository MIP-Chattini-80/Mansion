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

    public ObjetosDTO guardarObjeto(ObjetosDTO dto) {
        Objeto obje = new Objeto();
        if (dto.getNombreObjeto() != null) {
            obje.setNombre(dto.getNombreObjeto());
        }     
        if (dto.getTipoObjeto() != null) {
            obje.setTipoObjeto(dto.getTipoObjeto());
        }
        if (dto.getNombreHabitacion() != null) {
            obje.setIdHabitacion(dto.getNombreHabitacion());
        }
        Objeto guardado = objetoRepository.save(obje);
        return mapToDTO(guardado);
    }

    public ObjetosDTO actualizar(Long id, ObjetosDTO dto) {
        Objeto objetoExistente = objetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("¡El objeto no existe en los registros!"));
        if (dto.getNombreObjeto() != null) {
            objetoExistente.setNombre(dto.getNombreObjeto());
        }
        if (dto.getTipoObjeto() != null) {
            objetoExistente.setTipoObjeto(dto.getTipoObjeto());
        }
        if (dto.getNombreHabitacion() != null) {
            objetoExistente.setIdHabitacion(dto.getNombreHabitacion());
        }
        Objeto actualizado = objetoRepository.save(objetoExistente);
        return mapToDTO(actualizado);
    }
    
    public ObjetosDTO guardar(ObjetosDTO dto) {
        Objeto objeto = new Objeto();
        objeto.setNombre(dto.getNombreObjeto());
        objeto.setTipoObjeto(null);
        objeto.setIdHabitacion(dto.getNombreHabitacion());
        
        Objeto guardado = objetoRepository.save(objeto);
        return mapToDTO(guardado);
    }

    public void eliminar(Long id) {
        if (objetoRepository.existsById(id)) {
            objetoRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar: ID inexistente");
        }
    }

}