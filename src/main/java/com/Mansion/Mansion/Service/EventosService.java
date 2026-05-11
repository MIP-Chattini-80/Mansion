package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.Model.Eventos;
import com.Mansion.Mansion.Repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    public List<Eventos> listarCategorias() {
        return eventosRepository.findAll();
    }

    public Eventos guardarCategoria(Eventos eventos) {
        return eventosRepository.save(eventos);
    }

    public Eventos obtenerPorId(Long id) {
        return eventosRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        eventosRepository.deleteById(id);
    }
}