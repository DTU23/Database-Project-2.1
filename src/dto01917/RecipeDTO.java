package dto01917;

/**
 * Recept Data Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class RecipeDTO 
{
	/** Recept nr i omraadet 1-99999999 */
	int recipeId;
	/** Receptnavn min. 2 max. 20 karakterer */
	String recipeName;
	/** liste af kompenenter i recepten */
	
    
	public RecipeDTO(int recipeId, String recipeName)
	{
        this.recipeId = recipeId;
        this.recipeName = recipeName;
    }

    public int getRecipeId() { return recipeId; }
	public void setRecipeId(int receptId) { this.recipeId = receptId; }
	public String getRecipeName() { return recipeName; }
	public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
	public String toString() { 
		return recipeId + "\t" + recipeName; 
	}
}
