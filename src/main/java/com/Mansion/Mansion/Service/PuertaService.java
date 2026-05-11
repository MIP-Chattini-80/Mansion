package com.Mansion.Mansion.Service;


import com.Mansion.Mansion.Model.Puerta;
import com.Mansion.Mansion.Repository.PuertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuertaService {

    @Autowired
    private PuertaRepository puertaRepository;

    public List<Puerta> listarTodas() {
        return puertaRepository.findAll();
    }

    public Optional<Puerta> obtenerPorId(Long id) {
        return puertaRepository.findById(id);
    }

    public Puerta guardar(Puerta puerta) {
        return puertaRepository.save(puerta);
    }

    public void eliminar(Long id) {
        puertaRepository.deleteById(id);
    }
    
    public Puerta cambiarBloqueo(Long id, boolean bloqueada) {
        return puertaRepository.findById(id).map(puerta -> {
            puerta.setEstaBloqueada(bloqueada);
            return puertaRepository.save(puerta);
        }).orElse(null);
    }
}