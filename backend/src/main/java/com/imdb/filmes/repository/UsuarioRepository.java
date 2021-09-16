package com.imdb.filmes.repository;

import com.imdb.filmes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByLogin(String login);

    @Override
    Optional<Usuario> findById(Integer integer);
}
