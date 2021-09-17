package com.imdb.filmes.services;

import com.imdb.filmes.dto.VotoDTO;
import com.imdb.filmes.model.Filme;
import com.imdb.filmes.model.Usuario;
import com.imdb.filmes.model.Voto;
import com.imdb.filmes.repository.FilmeRepository;
import com.imdb.filmes.repository.VotoRepository;
import com.imdb.filmes.repository.UsuarioRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class VotoServiceImpl {

    private final UsuarioRepository usuarioRepository;
    private final FilmeRepository filmeRepository;
    private final VotoRepository votoRepository;

    public VotoServiceImpl(UsuarioRepository usuarioRepository, FilmeRepository filmeRepository, VotoRepository votoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.filmeRepository = filmeRepository;
        this.votoRepository = votoRepository;
    }

    @Transactional
    public Voto votar(VotoDTO voto){

        Usuario usuario = usuarioRepository.findById(voto.getIdUsuario()).get();
        Filme filme = filmeRepository.findById(voto.getIdFilme()).get();

        Voto novoVoto = new Voto();
        novoVoto.setVoto(voto.getVoto());
        novoVoto.setFilme(filme);
        novoVoto.setUsuario(usuario);

        return votoRepository.save(novoVoto);
    }
}
