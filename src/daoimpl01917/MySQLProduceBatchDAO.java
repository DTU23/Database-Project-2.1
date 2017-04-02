package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduceBatchDAO;
import dto01917.ProduceBatchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProduceBatchDAO implements ProduceBatchDAO {

	@Override
	public ProduceBatchDTO getRaavareBatch(int rbId) throws DALException {
		return null;
	}

	@Override
	public List<ProduceBatchDTO> getRaavareBatchList() throws DALException {
		return null;
	}

	@Override
	public List<ProduceBatchDTO> getRaavareBatchList(int raavareId) throws DALException {
		return null;
	}

	@Override
	public void createRaavareBatch(ProduceBatchDTO raavarebatch) throws DALException {

	}

	@Override
	public void updateRaavareBatch(ProduceBatchDTO raavarebatch) throws DALException {

	}
}
