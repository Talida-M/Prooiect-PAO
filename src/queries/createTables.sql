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
  idLoc int  DEFAULT NULL,
  PRIMARY KEY (idGal),
  KEY idLoc (idLoc),
  CONSTRAINT `loc_ibfk` FOREIGN KEY (`idLoc`) REFERENCES `adresa` (`idLoc`) ON DELETE CASCADE
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
  idLoc int  DEFAULT NULL,
  parola varchar(30) DEFAULT NULL,
  PRIMARY KEY (idClient),
  KEY idLoc (idLoc),
  CONSTRAINT `loc_ibfk_1` FOREIGN KEY (`idLoc`) REFERENCES `adresa` (`idLoc`) ON DELETE CASCADE
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



