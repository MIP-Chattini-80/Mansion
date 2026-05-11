package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Service.ObjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/instancias-objetos")
public class ObjetosController {

    @Autowired
    private ObjetosService objetosService;

    @GetMapping("/{id}")
    public List<ObjetosDTO> listar() {
        return objetosService.listarInstancias();
    }

    @PostMapping
    public ObjetosDTO guardar(@RequestBody ObjetosDTO dto) {
        return objetosService.guardar(dto);
    }

    @PutMapping("/{id}")
    public ObjetosDTO actualizar(@PathVariable Long id, @RequestBody ObjetosDTO dto) {
        return objetosService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        objetosService.eliminar(id);
    }
}