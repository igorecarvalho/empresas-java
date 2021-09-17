package com.imdb.filmes.repository;

import com.imdb.filmes.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Optional<Usuario> findByLogin(String login);

    @Override
    Optional<Usuario> findById(Integer integer);

    Usuario findUsuarioById(Integer id);

    @Query("SELECT u from USUARIOS u WHERE u.authorities not LIKE '%ADMIN%' and u.active = TRUE")
    public Page<Usuario> findActiveUsers(Pageable pageable);
}
