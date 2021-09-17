package com.imdb.filmes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "usuarios_filmes")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(0)
    @Max(4)
    private Integer voto;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_filme", referencedColumnName = "id")
    Filme filme;
}
