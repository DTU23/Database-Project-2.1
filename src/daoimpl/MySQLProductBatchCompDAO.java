package daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.Connector;
import daointerfaces.DALException;
import daointerfaces.ProductBatchCompDAO;
import dto.ProductBatchCompDTO;

public class MySQLProductBatchCompDAO implements ProductBatchCompDAO {

	private List<ProductBatchCompDTO> list = new ArrayList<ProductBatchCompDTO>();
	@Override
	public ProductBatchCompDTO getProductBatchComp(int pbId, int rbId) throws DALException {
		return null;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList(int pbId) throws DALException {
		ResultSet rs = Connector.doQuery("CALL get_batch_details_from_id("+pbId+");");
		try
		{
			while (rs.next())
			{
				list.add(new ProductBatchCompDTO(
				));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList() throws DALException {
		return this.list;
	}

	@Override
	public void createProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {
		list.add(productbatchcomponent);
	}

	@Override
	public void updateProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {
		list.remove(productbatchcomponent);
		list.add(productbatchcomponent);
	}
}
