CREATE SCHEMA IF NOT EXISTS food;

SET search_path TO food;

--CREAZIONE food.carrello_codicecarrello_seq
CREATE SEQUENCE food.carrello_codicecarrello_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.composizionecarrello_codicecarrello_seq
CREATE SEQUENCE food.composizionecarrello_codicecarrello_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.composizionecarrello_codiceseriale_seq
CREATE SEQUENCE food.composizionecarrello_codiceseriale_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.corriereper_codicerider_seq
CREATE SEQUENCE food.corriereper_codicerider_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.corriereper_codiceristorante_seq
CREATE SEQUENCE food.corriereper_codiceristorante_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.fornitura_codiceristorante_seq
CREATE SEQUENCE food.fornitura_codiceristorante_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.fornitura_codiceseriale_seq
CREATE SEQUENCE food.fornitura_codiceseriale_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.indirizzo_codiceindirizzo_seq
CREATE SEQUENCE food.indirizzo_codiceindirizzo_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.ordine_codicecarrello_seq
CREATE SEQUENCE food.ordine_codicecarrello_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.ordine_codicerider_seq
CREATE SEQUENCE food.ordine_codicerider_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.ordine_codiceristorante_seq
CREATE SEQUENCE food.ordine_codiceristorante_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.prodotto_codiceseriale_seq
CREATE SEQUENCE food.prodotto_codiceseriale_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.rider_codicerider_seq*/
CREATE SEQUENCE food.rider_codicerider_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.ristorante_codiceindirizzo_seq
CREATE SEQUENCE food.ristorante_codiceindirizzo_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.ristorante_codiceristorante_seq
CREATE SEQUENCE food.ristorante_codiceristorante_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.utente_codiceindirizzo_seq
CREATE SEQUENCE food.utente_codiceindirizzo_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.veicolo_codicerider_seq
CREATE SEQUENCE food.veicolo_codicerider_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--CREAZIONE food.veicolo_codiceseriale_seq
CREATE SEQUENCE food.veicolo_codiceseriale_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

--Definizione tabella indirizzi
CREATE TABLE indirizzo(
    nomevia VARCHAR(32),
    numerocivico VARCHAR(5),
    Cap CHAR(5),
    citta VARCHAR(64),
    provincia CHAR(2),
    codiceindirizzo SERIAL PRIMARY KEY
);

--Definizione tabella utente
CREATE TABLE utente(
    nome VARCHAR(32),
    cognome VARCHAR(32),
    email VARCHAR(64) PRIMARY KEY,
    password VARCHAR(32),
    numerotelefono CHAR(10),
    codiceindirizzo SERIAL NOT NULL,
    CONSTRAINT fk_indirizzo
    FOREIGN KEY (codiceindirizzo) REFERENCES indirizzo(codiceindirizzo)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

--Definizione tabella ristorante
CREATE TABLE ristorante(
    nome VARCHAR(32),
    descrizione VARCHAR(512),
    numerotelefono CHAR(10),
    codiceristorante SERIAL PRIMARY KEY,
    codiceindirizzo SERIAL NOT NULL,  
    CONSTRAINT fk_indirizzo
    FOREIGN KEY (codiceindirizzo) REFERENCES indirizzo(codiceindirizzo)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);

--Enumerazione per attributo tipoProdotto
CREATE TYPE TIPO_PRODOTTO AS ENUM('bevanda', 'cibo');

--Enumerazione per attributo categoria
CREATE TYPE CATEGORIA_PRODOTTO AS ENUM('alcolico', 'analcolico', 'antipasti', 'primi', 'secondi', 'contorni', 'dolci');

--Definizione tabella prodotto
CREATE TABLE prodotto(
    nome VARCHAR(32),
    prezzo REAL,
    codiceseriale SERIAL PRIMARY KEY,
    scadenza DATE,
    pathfoto VARCHAR(64),
    tipoprodotto TIPO_PRODOTTO NOT NULL,
    categoria CATEGORIA_PRODOTTO NOT NULL
);

--Definizione tabella fornitura
CREATE TABLE fornitura(
    quantitaprodotto INTEGER NOT NULL CHECK (quantitaProdotto > 0),
    codiceseriale SERIAL ,
    codiceristorante SERIAL ,
    PRIMARY KEY (codiceseriale, codiceristorante),
    CONSTRAINT fk_prodotto
    FOREIGN KEY (codiceseriale) REFERENCES prodotto(codiceseriale)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

--Definizione tabella rider
CREATE TABLE rider(
    nome VARCHAR(32),
    cognome VARCHAR(32),
    biografia VARCHAR(512),
    pathFoto VARCHAR(64),
    numeroattivita integer,
    codicerider SERIAL PRIMARY KEY
);

--Enumerazione per attributo tipoVeicolo
CREATE TYPE TIPO_VEICOLO AS ENUM ('moto', 'bicicletta');

--Definizione tabella Veicolo
CREATE TABLE veicolo(
    codiceseriale SERIAL PRIMARY KEY,
    annoimmatricolazione DATE,
    marca VARCHAR(32),
    modello VARCHAR(32),
    tipoveicolo TIPO_VEICOLO NOT NULL,
    codicerider SERIAL NOT NULL,
    CONSTRAINT fk_rider FOREIGN KEY(codicerider) REFERENCES rider(codicerider)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

--Definizione tabella ponte tra Rider e ristorante 
CREATE TABLE corrierePer(
    codiceristorante SERIAL,
    codicerider SERIAL,
    CONSTRAINT pk_corriere PRIMARY KEY(codicerider, codiceristorante),
    CONSTRAINT fk_rider FOREIGN KEY(codicerider) REFERENCES rider(codicerider)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_ristorante FOREIGN KEY(codiceristorante) REFERENCES ristorante(codiceristorante)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

--Definizione tabella carrello
CREATE TABLE carrello(
    data DATE NOT NULL,
    codicecarrello SERIAL PRIMARY KEY
); 

--Definizione tabella ponte tra Prodotto e Carrello 
CREATE TABLE composizioneCarrello(
    codicecarrello SERIAL,
    codiceseriale SERIAL,
    quantita INTEGER CHECK(quantita IS NOT NULL AND quantita > 0),
    CONSTRAINT pk_composizionecarrello PRIMARY KEY(codiceseriale, codicecarrello),
    CONSTRAINT fk_prodotto FOREIGN KEY(codiceseriale) REFERENCES prodotto(codiceseriale)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_carrello FOREIGN KEY(codicecarrello) REFERENCES carrello(codicecarrello)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

--Enumerazione per attributo stato
CREATE TYPE STATO_ORDINE AS ENUM ('A', 'N','NA');

--Definizione tabella ordine
CREATE TABLE ordine(
    codiceCarrello SERIAL,
    email VARCHAR(64),
    codiceristorante SERIAL,
    codicerider SERIAL,
    prezzo REAL,
    dataacquisto DATE,
    stato stato_ordine NOT NULL,
    PRIMARY KEY(codicecarrello, email, codiceristorante, codicerider),
    CONSTRAINT fk_carrello FOREIGN KEY(codicecarrello) REFERENCES carrello(codicecarrello)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_utente FOREIGN KEY(email) REFERENCES utente(email)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_rider FOREIGN KEY(codiceRider) REFERENCES rider(codicerider)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_ristorante FOREIGN KEY(codiceristorante) REFERENCES ristorante(codiceristorante)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

--Vincolo per associare rider a veicolo
CREATE VIEW riderVeicoloView AS 
SELECT R.codicerider, V.tipoveicolo
FROM rider AS R NATURAL JOIN veicolo AS V;

--Vincolo per nome
ALTER TABLE utente
    ADD CONSTRAINT chk_nome CHECK (nome ~* '[a-zA-Z]$');

--Vincolo per numero telefonico
ALTER TABLE utente
    ADD CONSTRAINT chk_numerotelefono CHECK (numerotelefono ~* '[0-9]{8}$');

--Vincolo per cognome
ALTER TABLE utente
    ADD CONSTRAINT chk_cognome CHECK (cognome ~* '[a-zA-Z]$');

ALTER TABLE Indirizzo
    ADD CONSTRAINT chk_cap CHECK (cap ~* '[0-9]{5}$');

--Vincolo per citta
ALTER TABLE indirizzo
    ADD CONSTRAINT chk_citta CHECK (citta ~* '[a-zA-Z]{1,}$');

--Vincolo per nome via
ALTER TABLE indirizzo
    ADD CONSTRAINT chk_nomevia CHECK (nomevia ~* '[a-zA-Z]{1,}$');

--Vincolo per numero_Civico
ALTER TABLE indirizzo
    ADD CONSTRAINT chk_numerocivico CHECK (numerocivico ~* '[a-zA-Z0-9]{1,}$');

--Vincolo per provincia
ALTER TABLE indirizzo
    ADD CONSTRAINT chk_provincia CHECK (provincia ~* '[a-zA-Z]{2}$');

--Vincolo tipoProdotto
ALTER TABLE prodotto
ADD CONSTRAINT chk_tipo_Prodotto CHECK (prodotto.tipoProdotto IN ('bevanda', 'cibo'));

--Vincolo categoria
ALTER TABLE prodotto
ADD CONSTRAINT chk_categoria CHECK (prodotto.categoria IN ('alcolico', 'analcolico', 'antipasti', 'primi', 'secondi', 'contorni', 'dolci'));

--Vincolo tipoVeicolo
ALTER TABLE veicolo
ADD CONSTRAINT chk_tipoVeicolo CHECK (veicolo.tipoVeicolo IN ('moto','bicicletta'));

-- trigger per email e password
CREATE FUNCTION food.controllo_email_password()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN  
   IF (NEW.email !~* '^[_A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+[.][A-Za-z]+$') THEN 
     RAISE EXCEPTION 'Errore: formato email non valido.'; 
   END IF; 
  
    IF (NEW.password ~* '^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$') THEN 
      RAISE EXCEPTION 'Errore: la password non valida'; 
    END IF; 
	 RETURN NEW; 
 END;
$BODY$;

CREATE TRIGGER verifico_email_password
    BEFORE INSERT
    ON food.utente
    FOR EACH ROW
    EXECUTE PROCEDURE food.controllo_email_password();


--trigger quantità prodotto non minori di zero
CREATE FUNCTION food."controllo_quantitaProdotto"()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN  
   IF (NEW.quantitaprodotto <= 0) THEN 
   RAISE EXCEPTION 'la quantità di prodotto deve essere maggiore di zero.'; 
   END IF;
 END;
$BODY$;

CREATE TRIGGER "controllo_quantitaProdotto"
    BEFORE INSERT OR UPDATE 
    ON food.fornitura
    FOR EACH ROW
    EXECUTE PROCEDURE food."controllo_quantitaProdotto"();

--trigger controllo lo stato dell'ordine
CREATE FUNCTION food.controllo_stato()
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
 
   RAISE EXCEPTION 'ERRORE: ordine non consegnato';
 
   RETURN NEW;
 
END
$BODY$;

CREATE TRIGGER "controllo_statoOrdine"
    AFTER UPDATE OF stato
    ON food.ordine
    FOR EACH ROW
    WHEN (NEW.stato = 'NA'::food.stato_ordine)
    EXECUTE PROCEDURE food.controllo_stato();

--vincolo per modifica password
CREATE FUNCTION food.modifica_password()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
     IF(new.password != old.password) THEN
       UPDATE utente SET password = new.password WHERE email = old.email;
     END IF;
   RETURN NEW; 
END;
$BODY$;

CREATE TRIGGER modifica_password
    BEFORE INSERT
    ON food.utente
    FOR EACH ROW
    EXECUTE PROCEDURE food.modifica_password();

--vincolo attività rider
CREATE FUNCTION food.controllo_attivitarider()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
   IF(new.numeroattivita>3) THEN
      RAISE EXCEPTION 'Errore: non è possibile associare al rider più di tre attività';
   END IF;
END;
$BODY$;

CREATE TRIGGER controllo_attivitarider
    BEFORE INSERT OR UPDATE 
    ON food.rider
    FOR EACH ROW
    WHEN (new.numeroattivita > 3)
    EXECUTE PROCEDURE food.controllo_attivitarider();

--vincolo controllo costo totale ordine
CREATE FUNCTION food.controllo_prezzo_ordine()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN  
   IF (NEW.prezzo <= 0) THEN 
   RAISE EXCEPTION 'prezzo totale ordine non corretto.'; 
   END IF;
 END;
$BODY$;

ALTER FUNCTION food.controllo_prezzo_ordine()
    OWNER TO postgres;

CREATE TRIGGER "controllo_costoTotaleOrdine"
    BEFORE INSERT
    ON food.ordine
    FOR EACH ROW
    EXECUTE PROCEDURE food.controllo_prezzo_ordine();


--Procedura inserisci veicolo
CREATE OR REPLACE PROCEDURE food.inserisci_veicolo(
	codiceseriale integer,
	annoimmatricolazione date,
	marca character varying,
	modello character varying,
	tipoveicolo food.tipo_veicolo,
	codicerider integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.veicolo VALUES(codiceseriale, annoimmatricolazione, marca, modello, tipoveicolo, codicerider); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci utente
CREATE OR REPLACE PROCEDURE food.inserisci_utente(
	nome character varying,
	cognome character varying,
	email character varying,
	password character varying,
	numerotelefono character,
	codiceindirizzo integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.utente VALUES(nome, cognome, email, password, numerotelefono, codiceindirizzo); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci ristorante
CREATE OR REPLACE PROCEDURE food.inserisci_ristorante(
	nome character varying,
	descrizione character varying,
	numerotelefonico character,
	codiceristorante integer,
	codiceindirizzo integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.ristorante VALUES(nome, descrizione, numerotelefonico, codiceristorante, codiceindirizzo); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci rider
CREATE OR REPLACE PROCEDURE food.inserisci_rider(
	nome character varying,
	cognome character varying,
	biografia character varying,
	pathfoto character varying,
	codicerider integer,
	numeroattivita integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.rider VALUES(nome, cognome, biografia, pathfoto, codicerider, numeroattivita); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci prodotto
CREATE OR REPLACE PROCEDURE food.inserisci_prodotto(
	nome character varying,
	prezzo real,
	codiceseriale integer,
	scadenza date,
	pathfoto character varying,
	tipoprodotto food.tipo_prodotto,
	categoria food.categoria_prodotto)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.prodotto VALUES(nome, prezzo, codiceseriale, scadenza, pathfoto, tipoprodotto,categoria); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci ordine
CREATE OR REPLACE PROCEDURE food.inserisci_ordine(
	codicecarrello integer,
	email character varying,
	codiceristorante integer,
	codicerider integer,
	prezzo real,
	dataaquisto date,
	stato food.stato_ordine)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.ordine VALUES(codicecarrello, email, codiceristorante, codicerider, prezzo, dataAquisto, stato ); 
COMMIT; 
END;
$BODY$;



--Procedura inserisci indirizzo
CREATE OR REPLACE PROCEDURE food.inserisci_indirizzo(
	nomevia character varying,
	cap character,
	citta character varying,
	provincia character,
	codiceindirizzo integer,
	numerocivico integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.indirizzo VALUES(nomevia, cap, citta, provincia, codiceindirizzo, numerocivico); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci fornitura
CREATE OR REPLACE PROCEDURE food.inserisci_fornitura(
	quantitaprodotto integer,
	codiceseriale integer,
	codiceristorante integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.fornitura VALUES(quantitaprodotto, codiceseriale, codiceristorante); 
COMMIT; 
END;
$BODY$;

--Procedura inserisci carrello
CREATE OR REPLACE PROCEDURE food.inserisci_carrello(
	data date,
	codicecarrello integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
INSERT INTO food.carrello VALUES(date, codicecarrello); 
COMMIT; 
END;
$BODY$;

--Procedura cancella utente
CREATE OR REPLACE PROCEDURE food.elimina_utente(
	emailutente character varying)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.utente where email=emailutente; 
END;
$BODY$;


--Procedura cancella veicolo
CREATE OR REPLACE PROCEDURE food.elimina_veicolo(
	codiceserialeveicolo integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.veicolo where codiceseriale=codiceserialeveicolo;
END;
$BODY$;


--Procedura cancella ristorante
CREATE OR REPLACE PROCEDURE food.elimina_ristorante(
	codcristorante integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.ristorante where codiceristorante=codCRistorante; 
END;
$BODY$;


--Procedura cancella rider
CREATE OR REPLACE PROCEDURE food.elimina_rider(
	codrider integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.rider where codicerider=codrider; 
END;
$BODY$;


--Procedura cancella prodotto
CREATE OR REPLACE PROCEDURE food.elimina_prodotto(
	nomeprodotto character varying)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.prodotto where nome=nomeProdotto; 
END;
$BODY$;

--Procedura cancella ordine
CREATE OR REPLACE PROCEDURE food.elimina_ordine(
	codcarrello integer,
	emailutente character varying,
	codristorante integer,
	codrider integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.ordine where codicecarrello=codcarrello AND email = emailutente AND codiceristorante=codristorante AND codicerider=codrider; 
END;
$BODY$;


--Procedura cancella indirizzo
CREATE OR REPLACE PROCEDURE food.elimina_indirizzo(
	codindirizzo integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.indirizzo where codiceindirizzo=codindirizzo;
END;
$BODY$;

--Procedura cancella carrello
CREATE OR REPLACE PROCEDURE food.elimina_carrello(
	codcarrello integer)
LANGUAGE 'plpgsql'
AS $BODY$
BEGIN 
DELETE FROM food.carrello where codicecarrello=codCarrello; 
END;
$BODY$;




