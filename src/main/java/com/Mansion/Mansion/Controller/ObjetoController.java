package com.Mansion.Mansion.Controller;

import com.Mansion.Mansion.DTO.ObjetosDTO;
import com.Mansion.Mansion.Service.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/objeto")
public class ObjetoController {

    @Autowired
    private ObjetoService objetoService;

    @GetMapping("/objeto/listar")
    public List<ObjetosDTO> listarBase() {
        return objetoService.listarTodo();
    }

    
}