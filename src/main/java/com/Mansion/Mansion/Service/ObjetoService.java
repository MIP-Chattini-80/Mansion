package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Model.Objeto;
import com.Mansion.Mansion.Repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public ObjetosDTO guardar(ObjetosDTO dto) {
        Objeto objeto = new Objeto();
        mapearEntidad(objeto, dto);
        return mapToDTO(objetoRepository.save(objeto));
    }

    public ObjetosDTO actualizar(Long id, ObjetosDTO dto) {
        Objeto objeto = objetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Objeto base no encontrado"));
        mapearEntidad(objeto, dto);
        return mapToDTO(objetoRepository.save(objeto));
    }

    public void eliminar(Long id) {
        objetoRepository.deleteById(id);
    }

    private void mapearEntidad(Objeto objeto, ObjetosDTO dto) {
        if (dto.getNombreObjeto() != null) objeto.setNombre(dto.getNombreObjeto());
        if (dto.getTipoObjeto() != null) objeto.setTipoObjeto(dto.getTipoObjeto());
    }

    private ObjetosDTO mapToDTO(Objeto modelo) {
        ObjetosDTO dto = new ObjetosDTO();
        dto.setIdObjeto(modelo.getIdObjeto());
        dto.setNombreObjeto(modelo.getNombre());
        dto.setTipoObjeto(modelo.getTipoObjeto());
        return dto;
    }
}