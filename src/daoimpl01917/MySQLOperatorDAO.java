package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatorDAO;
import dto01917.OperatorDTO;

public class MySQLOperatorDAO implements OperatorDAO {

	public OperatorDTO getOperator(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM operatoer WHERE opr_id = " + oprId + ";");
		try {
			if (!rs.first()) throw new DALException("Operator with id " + oprId + " does not exist");
			return new OperatorDTO (rs.getInt("opr_id"), rs.getString("opr_name"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getBoolean("admin"), rs.getString("role"));
		}
		catch (SQLException e) {throw new DALException(e); }
	}

	public void createOperator(OperatorDTO opr) throws DALException {		
		Connector.doUpdate("CALL create_operator(" + opr.getOprId() + "," + opr.getOprName() + "," + opr.getIni() + "," + 
				opr.getCpr() + "," + opr.getPassword() + "," + opr.getAdmin() + "," + opr.getRole() + ");");
	}

	public void updateOperator(OperatorDTO opr) throws DALException {
		Connector.doUpdate("CALL update_operator(" + opr.getOprId() + "," + opr.getOprName() + "," + opr.getIni() + "," + 
				opr.getCpr() + "," + opr.getPassword() + "," + opr.getAdmin() + "," + opr.getRole() + ");");
	}

	public List<OperatorDTO> getOperatorList() throws DALException {
		List<OperatorDTO> list = new ArrayList<OperatorDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM operator;");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatorDTO(rs.getInt("opr_id"), rs.getString("opr_name"), rs.getString("ini"), rs.getString("cpr"), rs.getString("password"), rs.getBoolean("admin"), rs.getString("role")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	public String getOperatorNameFromID(int oprId) throws DALException {
		ResultSet rs = Connector.doQuery("CALL get_operator_name_from_id(" + oprId + ");");
		try {
			if (!rs.first()) throw new DALException("Operator with id " + oprId + " does not exist");
			return rs.getString("opr_name");
		}
		catch (SQLException e) {throw new DALException(e); }
	}
}

