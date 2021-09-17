package com.imdb.filmes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String login;

    private String authorities;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Boolean active;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name="usuario_filme", joinColumns=
            {@JoinColumn(name="id_usuario")}, inverseJoinColumns=
            {@JoinColumn(name="id_filme")})
    private List<Filme> filmes;

}
