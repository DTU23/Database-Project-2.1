package daointerfaces;

import java.util.List;

import dto.ProduceDTO;

public interface ProduceDAO {
	ProduceDTO getProduce(int raavareId) throws DALException;
	List<ProduceDTO> getProduceList() throws DALException;
	void createProduce(ProduceDTO raavare) throws DALException;
	void updateProduce(ProduceDTO raavare) throws DALException;
}
