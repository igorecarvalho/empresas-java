package com.imdb.filmes.repository;

import com.imdb.filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    List<Filme> findByName(String name);

    Optional<Filme> findById(Long id);
//
//    @Query
//    Filme findByIdDetails(Long id);

}
