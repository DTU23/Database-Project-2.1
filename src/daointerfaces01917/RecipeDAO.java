package daointerfaces01917;

import java.util.List;

import dto01917.RecipeDTO;

public interface RecipeDAO {
	RecipeDTO getRecept(int receptId) throws DALException;
	List<RecipeDTO> getReceptList() throws DALException;
	void createRecept(RecipeDTO recept) throws DALException;
	void updateRecept(RecipeDTO recept) throws DALException;
}
