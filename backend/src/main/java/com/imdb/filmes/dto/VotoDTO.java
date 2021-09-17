package com.imdb.filmes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDTO {

    private Integer id;

    private Integer idUsuario;

    private Long idFilme;

    private Integer voto;
}
