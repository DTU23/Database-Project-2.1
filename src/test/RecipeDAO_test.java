package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import daoimpl.MySQLRecipeDAO;
import daointerfaces.DALException;

public class RecipeDAO_test {

	MySQLRecipeDAO recipe = new MySQLRecipeDAO();

	@Test
	public void test() {
		try {
			recipe.getRecipe(3);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
