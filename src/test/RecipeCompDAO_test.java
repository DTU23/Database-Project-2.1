package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import daoimpl.MySQLRecipeDAO;

public class RecipeCompDAO_test {

	@Before
	public void setUp() throws Exception {
		recipedao = new MySQLRecipeDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}