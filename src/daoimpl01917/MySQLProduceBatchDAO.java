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
	public ProduceBatchDTO getProduceBatch(int rbId) throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produce WHERE rb_id="+rbId+";");
		try{
			return new ProduceBatchDTO(rs.getInt("rb_id"), rs.getInt("produce_id"), rs.getDouble("amount"));
		}catch (SQLException e){ throw new DALException(e); }
	}

	@Override
	public List<ProduceBatchDTO> getProduceBatchList() throws DALException {
		List<ProduceBatchDTO> list = new ArrayList<ProduceBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM producebatch;");
		try
		{
			while (rs.next())
			{
				list.add(new ProduceBatchDTO(
						rs.getInt("rb_id"), rs.getInt("produce_id"), rs.getDouble("amount")
				));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduceBatchDTO> getProduceBatchList(int produceId) throws DALException {
		return null;
	}

	@Override
	public void createProduceBatch(ProduceBatchDTO producebatch) throws DALException {
		Connector.doQuery("INSERT INTO producebatch(rb_id, produce_id, amount) VALUES("+producebatch.getRbId()+", "+producebatch.getProduceId()+" ,"+producebatch.getAmount()+");");
	}

	@Override
	public void updateProduceBatch(ProduceBatchDTO producebatch) throws DALException {
		Connector.doQuery("UPDATE produce SET produce_id="+producebatch.getProduceId()+", amount="+producebatch.getAmount()+" WHERE pb_id="+producebatch.getRbId()+";");
	}
}
