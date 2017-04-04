package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.RecipeCompDAO;
import dto01917.RecipeCompDTO;

public class MySQLRecipeCompDAO implements RecipeCompDAO {

	@Override
	public RecipeCompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent WHERE recipe_id=" + receptId + " AND produce_id=" + raavareId + ";");
		try {
			return new RecipeCompDTO(rs.getInt("recipe_id"), rs.getInt("produce_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<RecipeCompDTO> getReceptKompList(int receptId) throws DALException {
		List<RecipeCompDTO> list = new ArrayList<RecipeCompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent WHERE recipe_id=" + receptId + ";");
		
		try {
			while (rs.next()) {
				list.add(new RecipeCompDTO(
						rs.getInt("recipe_id"),
						rs.getInt("produce_id"),
						rs.getDouble("nom_netto"),
						rs.getDouble("tolerance")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		
		return list;
	}

	@Override
	public List<RecipeCompDTO> getReceptKompList() throws DALException {
		List<RecipeCompDTO> list = new ArrayList<RecipeCompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent;");
		
		try {
			while (rs.next()) {
				list.add(new RecipeCompDTO(
						rs.getInt("recipe_id"),
						rs.getInt("produce_id"),
						rs.getDouble("nom_netto"),
						rs.getDouble("tolerance")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		
		return list;
	}

	@Override
	public void createReceptKomp(RecipeCompDTO receptkomponent) throws DALException {
		Connector.doQuery("CALL create_recipe_component(" + receptkomponent.getReceptId() + ", " + receptkomponent.getRaavareId() + ", " + receptkomponent.getNomNetto() + ", " + receptkomponent.getTolerance() + ");");		
	}

}
