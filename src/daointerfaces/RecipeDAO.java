package daointerfaces;

import java.util.List;

import dto.RecipeDTO;

public interface RecipeDAO {
	RecipeDTO getRecipe(int recipeId) throws DALException;
	List<RecipeDTO> getRecipeList() throws DALException;
	void createRecipe(RecipeDTO recipe) throws DALException;
}
