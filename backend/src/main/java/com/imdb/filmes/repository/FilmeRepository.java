package com.imdb.filmes.repository;

import com.imdb.filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByName(String name);

    Optional<Filme> findById(Long id);

    @Query("SELECT t, max(uf.voto) AS max FROM Filme t join Voto uf on (uf.filme.id = t.id) GROUP BY t order by max(uf.voto) desc")
    List<Filme> findAllDesc();

    @Query("SELECT f FROM Filme f WHERE f.name LIKE concat('%', :name, '%' ) OR f.diretor LIKE concat('%', :diretor, '%' ) OR f.genero LIKE  concat('%', :genero, '%' ) OR f.atores LIKE  concat('%', :atores, '%' )")
    List<Filme> findByFilters(@Param("name") String name, @Param("diretor") String diretor, @Param("genero") String genero, @Param("atores") String atores);

//    @Query("SELECT f.name, f.diretor, f.genero, f.atores, AVG(uf.voto) as media FROM Filme f join Voto uf on (uf.filme.id = f.id) WHERE f.id = :id")
//    Filme findByIdDetails(@Param("id") Long id);

}
