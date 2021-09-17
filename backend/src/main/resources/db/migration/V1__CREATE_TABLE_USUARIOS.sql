CREATE TABLE usuarios (
    id INT NOT NULL AUTO_INCREMENT,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    authorities VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE (login)
);

INSERT INTO usuarios (active,authorities,login,password) VALUES
(1,'ADMIN,USER','admin','$2a$12$HPniVMuICUCQwfBJUu8q.ehWPTyQxBezQH.zE./db2VmE6e4XN50i'),
(0,'ADMIN,USER','admin2','$2a$10$vg3WZYMgM2OctXDbNi8h4.tN/Gc/AOtFhCnuqi3Ds9GLUk/i8vRg6'),
(1,'USER','user','$2a$12$kYBkAXpzVfOswQFFIuXHm.Pd9w1ePLXntUye40wi6TRUWACFvU2FS'),
(0,'USER','user2','$2a$12$kYBkAXpzVfOswQFFIuXHm.Pd9w1ePLXntUye40wi6TRUWACFvU2FS');