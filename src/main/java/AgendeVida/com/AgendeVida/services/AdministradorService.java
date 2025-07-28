package AgendeVida.com.AgendeVida.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AgendeVida.com.AgendeVida.repositories.AdministradorDetalheRepository;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorDetalheRepository administradorDetalheRepository;
}
