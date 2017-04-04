package daointerfaces01917;

import java.util.List;

import dto01917.RecipeCompDTO;

public interface RecipeCompDAO {
	RecipeCompDTO getReceptKomp(int receptId, int raavareId) throws DALException;
	List<RecipeCompDTO> getReceptKompList(int receptId) throws DALException;
	List<RecipeCompDTO> getReceptKompList() throws DALException;
	void createReceptKomp(RecipeCompDTO receptkomponent) throws DALException;
}
