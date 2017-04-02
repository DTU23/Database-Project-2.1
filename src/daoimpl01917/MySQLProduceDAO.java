package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduceDAO;
import dto01917.ProduceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProduceDAO implements ProduceDAO {

	@Override
	public ProduceDTO getRaavare(int raavareId) throws DALException {
		return null;
	}

	@Override
	public List<ProduceDTO> getRaavareList() throws DALException {
		List<ProduceDTO> list = new ArrayList<ProduceDTO>();
		return list;
	}

	@Override
	public void createRaavare(ProduceDTO raavare) throws DALException {

	}

	@Override
	public void updateRaavare(ProduceDTO raavare) throws DALException {

	}
}
