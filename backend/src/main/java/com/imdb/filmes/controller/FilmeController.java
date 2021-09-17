package com.imdb.filmes.controller;


import com.imdb.filmes.model.Filme;
import com.imdb.filmes.services.FilmeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filme")
@Slf4j
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeServiceImpl filmesService;

    @Operation(summary = "Cadastro de filme",
            description = "Cadastro de filme",
            tags = {"filmes"})
    @PostMapping
    public ResponseEntity<Filme> save(@RequestBody @Valid Filme filme) {
        return ResponseEntity.ok(filmesService.save(filme));
    }

    @Operation(summary = "Listagem de todos os filmes paginados e ordenados",
            description = "Para usar paginação e ordenagem utilize: ?page='number'&sort='field' na url",
            tags = {"filmes"})
    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos(){
        return ResponseEntity.ok(filmesService.listAll());
    }

    @Operation(summary = "Lista um filme pelo ID",
            description = "O ID a ser buscado deve ser passado na url",
            tags = {"filmes"})
    @GetMapping(path = "/{id}")
    public ResponseEntity<Filme> findById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        log.info("User logged in {}", userDetails);
        return ResponseEntity.ok(filmesService.findFilme(id));
    }

    @Operation(summary = "Listagem filme por diretor, nome, gênero e/ou atores",
            description = "O paramentro de busca deve ser passado na url",
            tags = {"filmes"})
    @GetMapping(path = "/args")
    public ResponseEntity<List<Filme>> findByName(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok(filmesService.findByName(name));
    }

//    @Operation(summary = "Excluir filme",
//            description = "O ID a ser excluido deve ser passado na url",
//            tags = {"filmes"})
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable long id) {
//        filmesService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

//    @Operation(summary = "Editar filme por ID",
//            description = "O ID a ser editado deve ser passado na url",
//            tags = {"filmes"})
//    @PutMapping(path = "/{id}")
//    public ResponseEntity<Void> update(@RequestBody Filme filme) {
//        filmesService.update(filme);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @Operation(summary = "Desativa/Ativa filme",
//            description = "O ID a ser excluido deve ser passado na url",
//            tags = {"filmes"})
//    @PutMapping(path = "/deActivate/{id}")
//    public ResponseEntity<Void> deActivate(@RequestBody Filme filme) {
//        filmesService.deActivate(filme);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
