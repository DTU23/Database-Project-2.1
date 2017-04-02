package daointerfaces01917;

import java.util.List;

import dto01917.ProduceBatchDTO;

public interface ProduceBatchDAO {
	ProduceBatchDTO getProduceBatch(int rbId) throws DALException;
	List<ProduceBatchDTO> getProduceBatchList() throws DALException;
	List<ProduceBatchDTO> getProduceBatchList(int produceId) throws DALException;
	void createProduceBatch(ProduceBatchDTO producebatch) throws DALException;
	void updateProduceBatch(ProduceBatchDTO producebatch) throws DALException;
}
