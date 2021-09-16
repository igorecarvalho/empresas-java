package com.imdb.filmes.repository;

import com.imdb.filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findByName(String name);

    Filme findById(Long id);

}
