package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Model.Objetos;
import com.Mansion.Mansion.Repository.ObjetosRepository;
import com.Mansion.Mansion.Repository.ObjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjetosService {

    @Autowired
    private ObjetosRepository objetosRepository;
    
    @Autowired
    private ObjetoRepository objetoRepository;

    public List<ObjetosDTO> listarInstancias() {
        return objetosRepository.findAll().stream()
                .map(Objetos::convertirADTO).collect(Collectors.toList());
    }

    public ObjetosDTO guardar(ObjetosDTO dto) {
        Objetos instancia = new Objetos();
        if (dto.getIdObjeto() != null) {
            instancia.setOBJETObASE(objetoRepository.findById(dto.getIdObjeto()).orElse(null));
        }
        instancia.setEstado(dto.getEstado());
        instancia.setCantidad(dto.getCantidad());
        return objetosRepository.save(instancia).convertirADTO();
    }

    public ObjetosDTO actualizar(Long id, ObjetosDTO dto) {
        Objetos instancia = objetosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instancia no encontrada"));
        if (dto.getEstado() != null) instancia.setEstado(dto.getEstado());
        if (dto.getCantidad() != null) instancia.setCantidad(dto.getCantidad());     
        return objetosRepository.save(instancia).convertirADTO();
    }

    public void eliminar(Long id) {
        objetosRepository.deleteById(id);
    }
}