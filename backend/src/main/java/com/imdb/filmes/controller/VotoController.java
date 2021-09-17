package com.imdb.filmes.controller;


import com.imdb.filmes.model.Voto;
import com.imdb.filmes.services.VotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/voto")
@Slf4j
@RequiredArgsConstructor
public class VotoController {

    private final VotoServiceImpl votoService;

    @Operation(summary = "Cadastro de filme",
            description = "Cadastro de filme",
            tags = {"filmes"})
    @PostMapping
    public ResponseEntity<Voto> save(@RequestBody @Valid Voto voto) {
        return ResponseEntity.ok(votoService.save(voto));
    }
}
