package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RecipeDAO;
import dto01917.RecipeDTO;

public class MySQLReceptDAO implements RecipeDAO {

	@Override
	public RecipeDTO getRecept(int receptId) throws DALException {		
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe WHERE recipe_id = " + receptId + ";");
		try {
			if (!rs.first())
				throw new DALException("Recipe with id " + receptId + " does not exist");
			return new RecipeDTO(rs.getInt("recipe_id"), rs.getString("recipe_name"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<RecipeDTO> getReceptList() throws DALException {
		List<RecipeDTO> list = new ArrayList<RecipeDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe;");
		try {
			while (rs.next()) {
				list.add(new RecipeDTO(rs.getInt("recipe_id"), rs.getString("recipe_name")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void createRecept(RecipeDTO recept) throws DALException {
		Connector.doUpdate("CALL create_recipe(" + recept.getReceptNavn() + ");");
	}

}
