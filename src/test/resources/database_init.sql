create database blog;
drop database blog;
use blog;
CREATE TABLE IF NOT EXISTS users (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT null unique,
  password varchar(100) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS categoria (
  nome varchar(50) NOT NULL,
  PRIMARY KEY (nome)
);

CREATE TABLE IF NOT EXISTS articolo (
  id bigint unsigned NOT NULL AUTO_INCREMENT,
  titolo varchar(20) NOT NULL,
  categoria varchar(20) ,
  stato varchar(10) NOT NULL,
  sottotitolo varchar(20),
  testo text(500) NOT NULL,
  autore varchar(20) NOT NULL,
  data_creazione timestamp,
  data_pubblicazione timestamp not null,
  data_modifica timestamp ,
  id_user bigint unsigned NOT null,
  PRIMARY KEY (id),
  FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE cascade,
  FOREIGN KEY (categoria) REFERENCES categoria(nome) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tag (
  nome varchar(50) NOT NULL,
  PRIMARY KEY (nome)
);

CREATE TABLE IF NOT EXISTS articolo_tag(
	id_articolo bigint unsigned NOT NULL,
    nome_tag varchar(50) NOT null,
    FOREIGN KEY (id_articolo) REFERENCES articolo(id) ON DELETE cascade,
    FOREIGN KEY (nome_tag) REFERENCES tag(nome) ON DELETE cascade
);

--
--
-- ddinuzzo/password02
INSERT INTO users
(username, password)
VALUES('ddinuzzo', '$2a$10$vj3PqvSqQSsLhknZpxU2oOIUOdmm6cpPu1shwcyXHVzba.xBWLe4K');

insert into categoria values("Tecnologia");
insert into categoria values("Cucina");
insert into categoria values("Bio");

insert into tag values("tag 1");
insert into tag values("tag 2");
insert into tag values("tag 3");



insert into articolo values(0,"Titolo 1","Tecnologia", "bozza","sottotitolo1", "testo 1", "autore 1",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 1 );
insert into articolo values(0,"Titolo 2","Cucina", "pubblico","sottotitolo 2", "testo 2", "autore 2",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 1 );
insert into articolo values(0,"Titolo 3","Bio", "pubblico","sottotitolo 3", "testo 3", "autore 3",CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 1 );

insert into articolo_tag values(1,"tag 1");
insert into articolo_tag values(1,"tag 1");
insert into articolo_tag values(2,"tag 1");
