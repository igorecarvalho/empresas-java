package com.imdb.filmes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String diretor;

    private String genero;

    private String atores;

    @Transient
    private Double media;

    @OneToMany(mappedBy = "filme")
    private List<Voto> votos;
}
