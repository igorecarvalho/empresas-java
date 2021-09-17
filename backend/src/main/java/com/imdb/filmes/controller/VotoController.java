package com.imdb.filmes.controller;

import com.imdb.filmes.dto.VotoDTO;
import com.imdb.filmes.model.Usuario;
import com.imdb.filmes.model.Voto;
import com.imdb.filmes.services.VotoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("voto")
public class VotoController {

    private final VotoServiceImpl votoService;


    public VotoController(VotoServiceImpl votoService) {
        this.votoService = votoService;
    }

    @Operation(summary = "Realizer um novo voto",
            description = "O voto deve ser um valor entre 0 e 4",
            tags = {"voto"})
    @PostMapping
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Voto> votar(@RequestBody VotoDTO voto) {
        return ResponseEntity.ok(votoService.votar(voto));
    }

}
