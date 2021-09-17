CREATE TABLE usuarios_filmes (
     id INT NOT NULL AUTO_INCREMENT,
     voto INT,
     id_usuario INT,
     id_filme INT,
     PRIMARY KEY (id),
     FOREIGN KEY (id_usuario) REFERENCES usuarios (id),
     FOREIGN KEY (id_filme) REFERENCES filmes (id)
);
