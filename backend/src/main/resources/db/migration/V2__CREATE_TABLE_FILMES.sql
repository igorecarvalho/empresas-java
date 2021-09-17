CREATE TABLE filmes (
    id INT NOT NULL AUTO_INCREMENT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    name VARCHAR(255),
    diretor VARCHAR(255),
    genero VARCHAR(255),
    atores VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO imdb.filmes (active,name,diretor,genero,atores) VALUES
 (1,'filme 04','diretor04','genero01','ator03'),
 (1,'filme 01','diretor01','genero01','ator02'),
 (1,'filme 05','diretor06','genero02','ator06'),
 (1,'filme 07','diretor01','genero03','ator03'),
 (1,'filme 02','diretor02','genero03','ator02'),
 (1,'filme 03','diretor03','genero04','ator05'),
 (1,'filme 06','diretor03','genero06','ator03');
