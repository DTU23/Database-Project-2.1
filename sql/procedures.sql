DELIMITER //
CREATE PROCEDURE batch_details_from_id
(IN input INT)
BEGIN
  SELECT produktbatch.pb_id, produktbatch.status, produktbatch.recept_id, recept.recept_navn FROM produktbatch, recept
  WHERE produktbatch.pb_id = input;
END //
DELIMITER ;