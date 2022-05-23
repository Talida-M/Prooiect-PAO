CREATE TABLE opera (
  id int NOT NULL AUTO_INCREMENT,
  titlu varchar(30) DEFAULT NULL,
  an varchar(5)  DEFAULT NULL,
  stil varchar(30) DEFAULT NULL,
  pret int DEFAULT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE adresa (
  idLoc int NOT NULL AUTO_INCREMENT,
  strada varchar(30) DEFAULT NULL,
  tara varchar(30) DEFAULT NULL,
  oras varchar(30) DEFAULT NULL,
  codPostal int DEFAULT NULL,
  PRIMARY KEY (idLoc)
);

CREATE TABLE galerie (
  idGal int NOT NULL AUTO_INCREMENT,
  nume varchar(30) DEFAULT NULL,
  locatie character(40)  DEFAULT NULL,
  PRIMARY KEY (idGal)
);

CREATE TABLE expozitie (
  idE int NOT NULL AUTO_INCREMENT,
  titluExpozitie varchar(40) DEFAULT NULL,
  tip varchar(40) DEFAULT NULL,
  dataInceput varchar(13) DEFAULT NULL,
  dataSfarsit varchar(13) DEFAULT NULL,
  idGal int  DEFAULT NULL,
  PRIMARY KEY (idE),
  KEY idGal (idGal),
  CONSTRAINT `gal_ibfk` FOREIGN KEY (`idGal`) REFERENCES `galerie` (`idGal`) ON DELETE CASCADE
);

CREATE TABLE cont (
  idClient int NOT NULL AUTO_INCREMENT,
  nume varchar(30) DEFAULT NULL,
  prenume varchar(30) DEFAULT NULL,
  ziNastere varchar(13) DEFAULT NULL,
  email varchar(20) DEFAULT NULL,
  telefon varchar(12) DEFAULT NULL,
  adresa character(40)  DEFAULT NULL,
  parola varchar(30) DEFAULT NULL,
  PRIMARY KEY (idClient)
);
CREATE TABLE artist (
  idArt int NOT NULL AUTO_INCREMENT,
  idClient int NOT NULL,
  descriere character(200) DEFAULT NULL,
  PRIMARY KEY (idArt),
  KEY idLoc (idClient),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `cont` (`idClient`) ON DELETE CASCADE
);
Commit;
CREATE TABLE artistOpere (
  id int NOT NULL AUTO_INCREMENT,
  idArt int NOT NULL,
  idO int NOT NULL,
  PRIMARY KEY (id),
  KEY idArt (idArt),
  KEY idO (idO),
  CONSTRAINT `artist_ibfk_1` FOREIGN KEY (`idArt`) REFERENCES `artist` (`idArt`) ON DELETE CASCADE,
  CONSTRAINT `opera_ibfk_2` FOREIGN KEY (`idO`) REFERENCES `opera` (`id`) ON DELETE CASCADE
);
insert into `adresa`(`idLoc`, strada, tara, oras, `codPostal`) values (100,'Sct 3 Calea Victoriei Nr.30', 'Romania', 'Bucuresti','30029' );
insert into `galerie`(`idGal`, nume, `locatie`) values (0, 'Art is Life', 'Sct 3 Calea Victoriei Nr.30,Bucuresti');
insert into `opera` (id, titlu, an, stil, pret) value (2222, 'Ploaia', '2009','Abstract', 2000 );

Commit;
select * from galerie;
select * from adresa;