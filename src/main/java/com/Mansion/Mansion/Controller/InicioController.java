package com.Mansion.Mansion.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/inicio")
    public Map<String, String> inicio() {

        Map<String, String> inicio = new LinkedHashMap<>();

        inicio.put("bienvenida",
                "Bienvenido a La Mansion de los Ecos.");

        inicio.put("contexto",
                "Personajes de distintos universos despertaron atrapados dentro de una mansion fuera del tiempo y del espacio.");

        inicio.put("objetivo",
                "Explora habitaciones, encuentra objetos y descubre como reparar la maquina dimensional para regresar a casa.");

        inicio.put("interacciones",
                "Puedes explorar personajes, habitaciones, objetos y eventos usando los endpoints disponibles.");

        inicio.put("endpoints",
                "/personajes | /habitacion | /objeto | /objetos | /evento");

        inicio.put("advertencia",
                "Algunas habitaciones contienen secretos y objetos importantes para avanzar.");

        inicio.put("mensaje_final",
                "Buena suerte. La mansion cambia constantemente.");

        return inicio;
    }

}