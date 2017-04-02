package daointerfaces01917;

import java.util.List;

import dto01917.ProduceDTO;

public interface ProduceDAO {
	ProduceDTO getRaavare(int raavareId) throws DALException;
	List<ProduceDTO> getRaavareList() throws DALException;
	void createRaavare(ProduceDTO raavare) throws DALException;
	void updateRaavare(ProduceDTO raavare) throws DALException;
}
