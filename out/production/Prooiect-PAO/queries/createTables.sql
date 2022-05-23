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
insert into `opera` (id, titlu, an, stil, pret) value (2223, 'Sara', '1978','Expresionism', 3000 );
insert into `expozitie`(`idE`,`titluExpozitie`, tip, `dataInceput`, `dataSfarsit`, `idGal`) values (1111, 'Abstractul nu este doar o miscare', 'B(descoperire)', '10.08.2022', '13.08.2022', 1);
insert into `expozitie`(`titluExpozitie`, tip, `dataInceput`, `dataSfarsit`, `idGal`) values ( 'Dans si Pictura', 'A(educativ)', '23.10.2022', '20.10.2022', 1);
insert into `cont` (idClient, nume, prenume, `ziNastere`,email,telefon, adresa,parola) values (333, 'Ghenie', 'Adrian', '13-08-1977', 'ghenie@yahoo.com', '0987698712', 'Sct 3 St. N. Grigorescu Nr.20,Bucuresti', 'parola1');
insert into `artist`(`idArt`, `idClient`, descriere ) values (555, 333, 'Artist roman contemporan de talie internationala care, in ultimii ani a castigat o notorietate de mare anvergura. O lucrare  a fost vanduta pentru  1,1 mil$')
insert into `artistOpere`(`id`, `idArt`, `idO`) values (11, 555, 2223);
Commit;
select * from galerie;
select * from adresa;
select * from opera;
select * from cont;

