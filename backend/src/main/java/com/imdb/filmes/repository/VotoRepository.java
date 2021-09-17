package com.imdb.filmes.repository;

import com.imdb.filmes.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {

}
