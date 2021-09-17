package com.imdb.filmes.controller;

import com.imdb.filmes.model.Filme;
import com.imdb.filmes.model.Usuario;
import com.imdb.filmes.repository.UsuarioRepository;

import com.imdb.filmes.services.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UsuarioController {

    private final UsuarioServiceImpl repository;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioServiceImpl repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

//    @Operation(summary = "Listar todos os usuários",
//            description = "Exibe uma listagem de todos os usuários",
//            tags = {"users"})
//    @GetMapping(path = "/listarTodos")
//    public ResponseEntity<List<Usuario>> listarTodos() {
//        return ResponseEntity.ok(repository.listAll());
//    }

    @Operation(summary = "Listagem de usuários paginados e ordenados",
            description = "Para usar paginação e ordenagem utilize: ?page='number'&sort='field' na url",
            tags = {"user"})
    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<Usuario>> listarTodos(@PageableDefault(sort = "login",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 5) Pageable pageable){
        return ResponseEntity.ok(repository.findActiveUsers(pageable));
    }

    @Operation(summary = "Cadastrar um novo usuário",
            description = "Cadastro de novo usuário",
            tags = {"user"})
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }

    @Operation(summary = "Editar usuário por ID",
            description = "O ID a ser editado deve ser passado na url",
            tags = {"user"})
    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Usuario usuario) {
        repository.update(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Desativa/Ativa usuário por ID",
            description = "O ID a ser desativado deve ser passado na url",
            tags = {"user"})
    @PutMapping(path = "/deActivate/{id}")
    public ResponseEntity<Void> deActivate(@PathVariable Integer id) {
        repository.deActivate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
