DELIMITER //
CREATE PROCEDURE batch_details_from_id
(IN input INT)
BEGIN
  SELECT produktbatchkomponent.rb_id, raavare_navn, leverandoer, netto, opr_id
  FROM produktbatchkomponent NATURAL JOIN  raavare NATURAL JOIN  raavarebatch
  WHERE produktbatchkomponent.pb_id = input;
END //
DELIMITER ;