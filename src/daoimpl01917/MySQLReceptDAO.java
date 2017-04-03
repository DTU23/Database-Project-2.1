package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptDAO;
import dto01917.ReceptDTO;

public class MySQLReceptDAO implements ReceptDAO {

	@Override
	public ReceptDTO getRecept(int receptId) throws DALException {		
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe WHERE recipe_id = " + receptId + ";");
		try {
			if (!rs.first())
				throw new DALException("Recipe with id " + receptId + " does not exist");
			return new ReceptDTO(rs.getInt("recipe_id"), rs.getString("recipe_name"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ReceptDTO> getReceptList() throws DALException {
		List<ReceptDTO> list = new ArrayList<ReceptDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipe;");
		try {
			while (rs.next()) {
				list.add(new ReceptDTO(rs.getInt("recipe_id"), rs.getString("recipe_name")));
			}
		} catch (SQLException e) {
			throw new DALException(e);
		}
		return list;
	}

	@Override
	public void createRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate("CALL create_recipe(" + recept.getReceptNavn() + ");");
	}

	@Override
	public void updateRecept(ReceptDTO recept) throws DALException {
		Connector.doUpdate("UPDATE recipe SET recipe_name=" + recept.getReceptNavn() + "WHERE recipe_id=" + recept.getReceptId() + ");");	
	}

}
