package com.imdb.filmes.controller;

import com.imdb.filmes.model.Usuario;
import com.imdb.filmes.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @Operation(summary = "Listar todos os usuários",
            description = "Exibe uma listagem de todos os usuários",
            tags = {"users"})
    @GetMapping(path = "/listarTodos")
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }


    @Operation(summary = "Cadastrar um novo usuário",
            description = "Cadastro de novo usuário",
            tags = {"users"})
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }


//    @Operation(summary = "Validação de senha de usuário",
//            description = "Exibe uma listagem de todos os usuários",
//            tags = {"users"})
//    @GetMapping("/validarSenha")
//    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
//                                                @RequestParam String password) {
//
//        Optional<Usuario> optUsuario = repository.findByLogin(login);
//        if (optUsuario.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//        }
//
//        Usuario usuario = optUsuario.get();
//        boolean valid = encoder.matches(password, usuario.getPassword());
//
//        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//        return ResponseEntity.status(status).body(valid);
//    }
}
