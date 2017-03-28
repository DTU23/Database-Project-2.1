DELIMITER //
CREATE PROCEDURE batch_details_from_id
(IN input INT)
BEGIN
  SELECT produktbatchkomponent.rb_id, raavare_navn, leverandoer, netto, opr_id
  FROM produktbatchkomponent NATURAL JOIN  raavare NATURAL JOIN  raavarebatch
  WHERE produktbatchkomponent.pb_id = input;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE new_product_batch
(IN recept_id_input INT)
BEGIN
  INSERT INTO produktbatch(status, recept_id) VALUES(0, recept_id_input);
END //
DELIMITER ;