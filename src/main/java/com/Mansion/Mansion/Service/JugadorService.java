package com.Mansion.Mansion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mansion.Mansion.Model.Jugador;
import com.Mansion.Mansion.Repository.JugadorRepository;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

}