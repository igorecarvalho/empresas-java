package com.imdb.filmes.repository;

import com.imdb.filmes.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query("SELECT AVG(uf.voto) as media FROM Voto uf WHERE uf.filme.id = :id")
    Double mediaFilme(@Param("id") Long id);
}
