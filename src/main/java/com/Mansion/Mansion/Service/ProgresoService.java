package com.Mansion.Mansion.Service;

import com.Mansion.Mansion.Model.Progreso;
import com.Mansion.Mansion.Repository.ProgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoService {

    @Autowired
    private ProgresoRepository progresoRepository;

    public List<Progreso> listarTodo() {
        return progresoRepository.findAll();
    }

    public Optional<Progreso> obtenerPorId(Long id) {
        return progresoRepository.findById(id);
    }

    public Progreso guardar(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    public void eliminar(Long id) {
        progresoRepository.deleteById(id);
    }

    public Progreso actualizarExperiencia(Long id, int nuevaExperiencia) {
        return progresoRepository.findById(id).map(progreso -> {
            progreso.setPuntosExperiencia(nuevaExperiencia);
            if (nuevaExperiencia >= 1000) {
                progreso.setNivelActual(progreso.getNivelActual() + 1);
            }
            return progresoRepository.save(progreso);
        }).orElse(null);
    }
    
}