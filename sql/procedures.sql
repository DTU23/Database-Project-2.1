DROP PROCEDURE IF EXISTS get_batch_details_from_id;
DROP PROCEDURE IF EXISTS create_product_batch_from_recept_id;
DROP PROCEDURE IF EXISTS create_produce_batch_from_produce_id;
DROP PROCEDURE IF EXISTS create_recipe;
DROP PROCEDURE IF EXISTS create_produce;
DROP PROCEDURE IF EXISTS delete_produce_batch_from_produce_id;
DROP PROCEDURE IF EXISTS create_recipe_component;
DROP PROCEDURE IF EXISTS create_operator;
DROP PROCEDURE IF EXISTS update_operator;
DROP PROCEDURE IF EXISTS get_operator_name_from_id;
/**

 */
DELIMITER //
CREATE PROCEDURE get_batch_details_from_id
(IN input INT)
BEGIN
  SELECT produktbatchkomponent.rb_id, raavare_navn, leverandoer, netto, opr_id
  FROM produktbatchkomponent NATURAL JOIN  raavare NATURAL JOIN  raavarebatch
  WHERE produktbatchkomponent.pb_id = input;
END //
DELIMITER ;

/**
Foreman
 */
DELIMITER //
CREATE PROCEDURE create_product_batch_from_recept_id
(IN recept_id_input INT)
BEGIN
  INSERT INTO produktbatch(status, recept_id) VALUES(0, recept_id_input);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE create_produce_batch_from_produce_id
(IN input_maengde DOUBLE, IN input_rb_id INT)
BEGIN
  INSERT INTO raavarebatch(maengde, raavare_id) VALUES(input_maengde, input_rb_id);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_produce_batch_from_produce_id
(IN input_rb_id INT)
BEGIN
  DELETE FROM raavarebatch WHERE raavarebatch.raavare_id = input_rb_id;
END //
DELIMITER ;

/**
Pharmacist
 */
DELIMITER //
CREATE PROCEDURE create_recipe
(IN input_recept_navn TEXT)
BEGIN
  INSERT INTO recept(recept_navn) VALUES(input_recept_navn);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE create_produce
(IN input_produce_name TEXT, IN input_produce_leverandoer TEXT)
BEGIN
  INSERT INTO raavare(raavare_navn, leverandoer) VALUES(input_produce_name, input_produce_leverandoer);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE create_recipe_component
(
  IN input_recipe_id INT,
  IN input_produce_id INT,
  IN input_netto DOUBLE,
  IN input_tolerance DOUBLE
)
BEGIN
  INSERT INTO receptkomponent(recept_id, raavare_id, nom_netto, tolerance)
  VALUES(input_recipe_id, input_produce_id, input_netto, input_tolerance);
END //
DELIMITER ;

/**
Admin
*/
DELIMITER //
CREATE PROCEDURE create_operator
(
  IN input_id INT,
  IN input_name TEXT,
  IN input_initials TEXT,
  IN input_cpr TEXT,
  IN input_password TEXT
)
BEGIN
  INSERT INTO operatoer(opr_id, opr_navn, ini, cpr, password) VALUES(input_id, input_name, input_initials, input_cpr, input_password);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_operator
(
  IN input_id INT,
  IN input_name TEXT,
  IN input_initials TEXT,
  IN input_cpr TEXT,
  IN input_password TEXT
)
BEGIN
  UPDATE operatoer SET
    opr_navn=input_name,
    ini = input_initials,
    cpr = input_cpr,
    password = input_password
  WHERE input_id = opr_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_operator_name_from_id
(
  IN input_id INT
)
BEGIN
  SELECT opr_navn FROM operatoer WHERE opr_id = input_id;
END //
DELIMITER ;