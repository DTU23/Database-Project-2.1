package daointerfaces;

import java.util.List;

import dto.ProduceBatchDTO;

public interface ProduceBatchDAO {
	ProduceBatchDTO getRaavareBatch(int rbId) throws DALException;
	List<ProduceBatchDTO> getRaavareBatchList() throws DALException;
	List<ProduceBatchDTO> getRaavareBatchList(int raavareId) throws DALException;
	void createRaavareBatch(ProduceBatchDTO raavarebatch) throws DALException;
	void updateRaavareBatch(ProduceBatchDTO raavarebatch) throws DALException;
}

