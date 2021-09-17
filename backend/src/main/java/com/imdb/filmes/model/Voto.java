package com.imdb.filmes.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "usuario_filme")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Max(4)
    private Integer voto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_filme", referencedColumnName = "id")
    Filme filme;
}
