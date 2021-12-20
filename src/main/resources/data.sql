-- Inserting parties into database
REPLACE INTO parties(id, name, symbol) VALUES(1, 'Socialdemokratiet', 'A');
REPLACE INTO parties(id, name, symbol) VALUES(2, 'Det Konservative Folkeparti', 'C');
REPLACE INTO parties(id, name, symbol) VALUES(3, 'SF, Socialistisk Folkeparti', 'F');
REPLACE INTO parties(id, name, symbol) VALUES(4, 'Dansk Folkeparti', 'O');
REPLACE INTO parties(id, name, symbol) VALUES(5, 'Venstre', 'V');
REPLACE INTO parties(id, name, symbol) VALUES(6, 'Enhedslisten', 'Ø');

-- Inserting candidates for Socialdemokratiet
INSERT INTO candidates(id, first_name, last_name, party) VALUES(1, 'Marcel', 'Meijer', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(2, 'Michael', 'Kristensen', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(3, 'Helle', 'Hansen', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(4, 'Karina', 'Knobelauch', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(5, 'Stefan Hafstein', 'Wolffbrandt', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(6, 'Robert V.', 'Rasmussen', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(7, 'Pia', 'Ramsing', 1);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(8, 'Anders Baun', 'Sørensen', 1);

-- Inserting candidates for Det Konservative Folkeparti
INSERT INTO candidates(id, first_name, last_name, party) VALUES(9, 'Per Urban', 'Olsen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(10, 'Peter', 'Askjær', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(11, 'Martin', 'Sørensen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(12, 'Louise', 'Bramstorp', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(13, 'Sigfred', 'Jensen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(14, 'Jørn C.', 'Nissen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(15, 'Morten Ø.', 'Kristensen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(16, 'Susanne', 'Andersen', 2);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(17, 'Iulian V.', 'Paiu', 2);

-- Inserting candidates for SF, Socialistisk Folkeparti
INSERT INTO candidates(id, first_name, last_name, party) VALUES(18, 'Ulla', 'Holm', 3);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(19, 'Kjeld', 'Bønkel', 3);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(20, 'Anne Grethe', 'Olsen', 3);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(21, 'Lone', 'Krag', 3);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(22, 'Børge S.', 'Buur', 3);

-- Inserting candidates for Dansk Folkeparti
INSERT INTO candidates(id, first_name, last_name, party) VALUES(23, 'Per', 'Mortensen', 4);

-- Inserting candidates for Venstre
INSERT INTO candidates(id, first_name, last_name, party) VALUES(24, 'Søren', 'Wiese', 5);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(25, 'Anita E. H.', 'Olesen', 5);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(26, 'Carsten', 'Bruun', 5);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(27, 'Mogens', 'Exner', 5);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(28, 'Anja', 'Guldborg', 5);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(29, 'Klaus', 'Holdorf', 5);

-- Inserting candidates for Enhedslisten
INSERT INTO candidates(id, first_name, last_name, party) VALUES(30, 'Katrine Høegh', 'Mc Quaid', 6);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(31, 'Jette M.', 'Søgaard', 6);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(32, 'Søren', 'Caspersen', 6);
INSERT INTO candidates(id, first_name, last_name, party) VALUES(33, 'Pia', 'Birkmand', 6);







