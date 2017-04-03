package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ReceptKompDAO;
import dto01917.ReceptKompDTO;

public class MySQLReceptKompDAO implements ReceptKompDAO {

	@Override
	public ReceptKompDTO getReceptKomp(int receptId, int raavareId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent WHERE recipe_id=" + receptId + " AND produce_id=" + raavareId + ";");
		try {
			return new ReceptKompDTO(rs.getInt("recipe_id"), rs.getInt("produce_id"), rs.getDouble("nom_netto"), rs.getDouble("tolerance"));
		} catch (SQLException e) {
			throw new DALException(e);
		}
	}

	@Override
	public List<ReceptKompDTO> getReceptKompList(int receptId) throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent WHERE recipe_id=" + receptId + ";");
		
		try {
			while (rs.next()) {
				list.add(new ReceptKompDTO(
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
	public List<ReceptKompDTO> getReceptKompList() throws DALException {
		List<ReceptKompDTO> list = new ArrayList<ReceptKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM recipecomponent;");
		
		try {
			while (rs.next()) {
				list.add(new ReceptKompDTO(
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
	public void createReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doQuery("CALL create_recipe_component(" + receptkomponent.getReceptId() + ", " + receptkomponent.getRaavareId() + ", " + receptkomponent.getNomNetto() + ", " + receptkomponent.getTolerance() + ");");		
	}

	@Override
	public void updateReceptKomp(ReceptKompDTO receptkomponent) throws DALException {
		Connector.doQuery("UPDATE recipecomponent SET nom_netto=" + receptkomponent.getNomNetto() + ", tolerance=" + receptkomponent.getTolerance() + " WHERE recipe_id=" + receptkomponent.getReceptId() + " AND produce_id=" + receptkomponent.getRaavareId() + ";");		
	}

}
