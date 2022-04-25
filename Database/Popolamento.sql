SET search_path TO food;


--Popolamento tabella indirizzo
INSERT INTO indirizzo(nomeVia, numeroCivico, CAP, citta, provincia) VALUES
('coolstreet', 3, '84012', 'coolcity', 'SA'),
('dundermifflin', 9, '18512', 'scranton', 'US'),
('nazionale', 29, '84070', 'sangiovanniapiro', 'SA'),
('leopardi', 24, '80125', 'napoli', 'NA'),
('claudio', 21, '80125', 'napoli', 'NA'),
('sucuzzone', 34, '71420', 'maratea', 'PZ'),
('answer', 42, '50003', 'question', 'EN'),
('guercet', 33, '57129', 'vallais', 'CH');

--Popolamento tabella utente
INSERT INTO utente(nome, cognome, email, password, numeroTelefono, codiceIndirizzo) VALUES
('antonio', 'verdi', 'fakemail@domain.com', 'Secure9@', '3333337890', 4),
('michael', 'scoot', 'bestboss@ever.com', 'passwo8#', '1231234567', 3),
('dwight', 'schrute', 'assistant@live.it', 'beetsf8@', '4454356760', 3),
('arthur', 'dent', 'dont@panic.com', 'dontpa4#', '3456783331', 8),
('achille', 'tartaruga', 'geb@egb.com', 'granch3@', '3333333333', 2),
('isaac', 'asimov', 'sci@fi.com', 'fondaz2@', '7345689231', 2),
('puja', 'suez', 'papa@pujaz.it', 'sgaper7@', '4572891206', 4),
('jorge', 'borges', 'book@ofsand.com', 'alephw1#', '0123456789', 5),
('gregor', 'samsa', 'blatta@vendor.com', 'passwo5@', '2344327896', 7);

--Popolamento tabella prodotto
INSERT INTO prodotto(nome, prezzo, scadenza, pathFoto, tipoProdotto, categoria) VALUES
('margherita', 3.50, '2021-05-23', '/', 'cibo', 'primi'),
('diavola', 4.50, '2021-04-09', '/', 'cibo', 'primi'),
('bianca', 3.00, '2021-04-25', '/', 'cibo', 'primi'),
('spaghetti', 5.00, '2021-04-16', '/', 'cibo', 'primi'),
('fiorentina', 30.00, '2021-03-31', '/', 'cibo', 'secondi'),
('filetto', 35.00, '2021-03-28', '/', 'cibo', 'secondi'),
('tbone', 27.00, '2021-03-30', '/', 'cibo', 'secondi'),
('salmone', 25.00, '2021-03-24', '/', 'cibo', 'secondi'),
('tonno', 26.00, '2021-03-22', '/', 'cibo', 'secondi'),
('falafel', 15.00, '2021-04-18', '/', 'cibo', 'secondi'),
('nuggets', 7.00, '2022-02-13', '/', 'cibo', 'secondi'),
('insalata', 3.00, '2021-03-13', '/', 'cibo', 'contorni'),
('patatine', 4.00, '2021-06-21', '/', 'cibo', 'contorni'),
('pomodori', 3.00, '2021-03-13', '/', 'cibo', 'contorni'),
('zeppole', 5.00, '2021-03-13', '/', 'cibo', 'dolci'),
('torta', 7.00, '2021-03-17', '/', 'cibo', 'dolci'), 
('panettone', 4.50, '2021-03-19', '/', 'cibo', 'dolci'), 
('mare', 7.00, '2021-03-14', '/', 'cibo', 'antipasti'), 
('monti', 6.50, '2021-03-17', '/', 'cibo', 'antipasti'), 
('mare-monti', 10.00, '2021-03-14', '/', 'cibo', 'antipasti'),
('vegano', 6.00, '2021-06-25', '/', 'cibo', 'antipasti'),
('acqua', 1.00, '2028-01-01', '/', 'bevanda', 'analcolico'),
('coca', 2.00, '2022-09-20', '/', 'bevanda', 'analcolico'),
('aranciata', 2.00, '2022-10-27', '/', 'bevanda', 'analcolico'),
('gassosa', 2.00, '2022-08-14', '/', 'bevanda', 'analcolico'),
('succo-frutta', 2.50, '2021-05-20', '/', 'bevanda', 'analcolico'),
('birra', 1.50, '2021-12-25', '/', 'bevanda', 'alcolico'),
('vino-rosso', 2.50, '2021-09-25', '/', 'bevanda', 'alcolico'),
('vino-bianco', 3.50, '2021-07-10', '/', 'bevanda', 'alcolico'),
('mojito', 4.00, '2021-11-03', '/', 'bevanda', 'alcolico');

--Popolamento tabella ristorante
INSERT INTO ristorante(nome, descrizione, numeroTelefono, codiceIndirizzo) VALUES
('gnab-gib', 'ristorante al termine dell`universo', '0001112229', 7),
('eco', 'il nome sta per economico', '8000774563', 6),
('enigma', 'il nome e` il vero enigma', '2340255363', 3);

--Popolamento tabella rider
INSERT INTO rider(nome, cognome, biografia, pathFoto) VALUES
('abdul', 'alhazred', 'dice di essere un rider veloce ed efficiente', '/',2),
('philip', 'fry', 'ha paura di cadere nei frigoriferi', '/',1),
('gennaro', 'esposito', 'scegli me non te ne pentirai', '/',1),
('pasquale', 'esposito', 'se vuoi un pasto caldo in 5 minuti chiama me', '/',2),
('palmer', 'eldrich', 'consegna anche can-d', '/',3),
('wow', 'bagger', 'ha avuto un problema con degli elastici, un pranzo liquido e un acceleratore di particelle', '/',2),
('corrado', 'corriere', 'dice di essere predestinato a questo lavoro', '/',1);

--Popolamento tabella veicolo
INSERT INTO veicolo(annoImmatricolazione, marca, modello, tipoVeicolo, codiceRider) VALUES
('2016-02-17', 'lancia', 'economica', 'bicicletta', 7),
('2012-06-27', 'lancia', 'economica_motorizzata', 'moto', 7),
('2018-01-02', 'post', 'gres', 'moto', 3),
('2000-03-12', 'fiat', 'mezza_panda', 'moto', 2),
('2009-12-08', 'piaggio', 'liberty', 'moto', 4),
('2009-12-08', 'piaggio', 'zip', 'moto', 4),
('1997-12-08', 'marin', 'graziella', 'bicicletta', 4),
('2008-04-09', 'trek', 'graziella', 'bicicletta', 5),
('2008-07-11', 'cthulhu', 'squid', 'moto', 1),
('2020-01-18', 'dreaming', 'nightmare', 'bicicletta', 1),
('2020-01-18', 'space', 'invaders', 'bicicletta', 6),
('2020-01-18', 'space', 'milkyway', 'moto', 6),
('2020-01-18', 'volta', 'greenpower', 'bicicletta', 6),
('2020-01-18', 'volta', 'semigreenpower', 'moto', 6);

--Popolamento tabella corrierePer
INSERT INTO corrierePer(codiceRider, codiceRistorante) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 3),
(3, 2),
(4, 1),
(4, 2),
(5, 2),
(5, 3),
(6, 1),
(6, 2),
(6, 3),
(7, 1);

--Popolamento tabella ordine
INSERT INTO ordine(codicecarrello, email, codiceristorante, codiceRider, prezzo, dataAcquisto, stato) VALUES
(1, 'assistant@live.it', 2, 6, 40, '2021-05-23', 'A'),
(3, 'book@ofsand.com', 2, 32, 20.9, '2022-01-01', 'N');

--Popolamento tabella composizionecarrello
INSERT INTO composizionecarrello(codicecarrello, codiceseriale, quantità) VALUES
(2, 7, 1),
(4, 8, 1),
(5, 5, 1);

--Popolamento tabella carrello
INSERT INTO carrello(data, codicecarrello) VALUES
('2021-12-27', 1),
('2021-12-27', 2),
('2021-07-20', 3),
('2021-12-27', 4),
('2021-12-27', 5);

--Popolamento tabella fornitura
INSERT INTO fornitura(codiceRistorante, codiceSeriale, quantitaProdotto) VALUES
(1, 1, 120),
(1, 2, 46),
(1, 3, 19),
(1, 4, 21),
(1, 12, 70),
(1, 17, 23),
(1, 27, 37),
(1, 22, 200),
(1, 23, 160),
(2, 5, 9),
(2, 6, 16),
(2, 7, 40),
(2, 8, 12),
(2, 9, 27),
(2, 10, 33),
(2, 11, 70),
(2, 12, 14),
(2, 13, 70),
(2, 14, 48),
(2, 20, 84),
(2, 21, 68),
(2, 19, 18),
(2, 18, 81),
(2, 16, 100),
(3, 15, 32),
(3, 24, 12),
(3, 25, 72),
(3, 26, 48),
(3, 28, 87),
(3, 27, 23),
(3, 29, 31),
(3, 30, 21);


