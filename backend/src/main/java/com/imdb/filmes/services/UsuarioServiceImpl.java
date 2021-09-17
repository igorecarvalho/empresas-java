package com.imdb.filmes.services;

import com.imdb.filmes.data.UsuarioData;
import com.imdb.filmes.model.Usuario;
import com.imdb.filmes.repository.UsuarioRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByLogin(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UsuarioData(usuario);
    }

//    @Query(value = "SELECT DISTINCT u.authorities, u.login from filmes.usuario u WHERE u.active = FALSE and u.authorities like '%ADMIN%'")
    public Page<Usuario> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Usuario> findActiveUsers(Pageable pageable) {
        return repository.findActiveUsers(pageable);
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario usuario){
        return repository.save(usuario);
    }

    public void update(Usuario usuario){
        repository.save(usuario);
    }

    public void deActivate(Integer id) {
        Usuario usuario = repository.findUsuarioById(id);
        usuario.setActive(!usuario.getActive());
        repository.save(usuario);
    }

}
