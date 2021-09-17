package com.imdb.filmes.services;

import com.imdb.filmes.model.Voto;
import com.imdb.filmes.repository.VotoRepository;
import org.springframework.stereotype.Component;

@Component
public class VotoServiceImpl {

    private final VotoRepository votoRepository;


    public VotoServiceImpl(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    public void votar(Voto voto){
        votoRepository.save(voto);
    }

    public Voto save(Voto voto) {
        return votoRepository.save(voto);
    }
}
