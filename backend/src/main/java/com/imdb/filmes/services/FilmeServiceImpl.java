package com.imdb.filmes.services;

import com.imdb.filmes.model.Filme;
import com.imdb.filmes.repository.FilmeRepository;
import com.imdb.filmes.repository.VotoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FilmeServiceImpl {

    private final FilmeRepository filmeRepository;
    private final VotoRepository votoRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository, VotoRepository votoRepository) {
        this.filmeRepository = filmeRepository;
        this.votoRepository = votoRepository;
    }

    public List<Filme> listAll() {
        return filmeRepository.findAllDesc();
    }

    public List<Filme> findByName(String name) {
        return filmeRepository.findByName(name);
    }

    public List<Filme> findByFilters(String name, String diretor, String genero, String atores){
        return filmeRepository.findByFilters(name, diretor, genero, atores);
    }

//    public Filme findById(Long id) {
//        return filmeRepository.findById(id).get();
//    }

    public Filme findFilme(Long id) {
        Filme filme = filmeRepository.findById(id).get();
        Double media = votoRepository.mediaFilme(id);
        filme.setMedia(media);
        return filme;
    }

    @Transactional
    public Filme save(Filme filme){
        return filmeRepository.save(filme);
    }

//    public void delete(long id) {
//        filmeRepository.delete(filmeRepository.findById(id).get());
//    }

    public void update(Filme filme) {
        filmeRepository.save(filme);
    }

}
