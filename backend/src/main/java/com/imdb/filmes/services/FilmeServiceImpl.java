package com.imdb.filmes.services;

import com.imdb.filmes.model.Filme;
import com.imdb.filmes.repository.FilmeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FilmeServiceImpl {

    private final FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

//    @Query(value = "SELECT DISTINCT u.authorities, u.login from filmes.usuario u WHERE u.active = FALSE and u.authorities like '%ADMIN%'")
    public Page<Filme> listAll(Pageable pageable) {
        return filmeRepository.findAll(pageable);
    }

    public List<Filme> findByName(String name) {
        return filmeRepository.findByName(name);
    }

    public Filme findById(long id) {
        return filmeRepository.findById(id);
    }

    @Transactional
    public Filme save(Filme filme){
        return filmeRepository.save(filme);
    }

    public void delete(long id) {
        filmeRepository.delete(filmeRepository.findById(id));
    }

    public void update(Filme filme) {
        filmeRepository.save(filme);
    }

    public void deActivate(Filme filme) {
        filme.setActive(!filme.getActive());
    }
}
