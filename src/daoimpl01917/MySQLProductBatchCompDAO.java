package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchCompDAO;
import dto01917.ProductBatchCompDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductBatchCompDAO implements ProductBatchCompDAO {

	@Override
	public ProductBatchCompDTO getProductBatchComp(int pbId, int rbId) throws DALException {
		return null;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList(int pbId) throws DALException {
		List<ProductBatchCompDTO> list = new ArrayList<ProductBatchCompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM product_batch_list;");
		try
		{
			while (rs.next())
			{
				list.add(new ProductBatchCompDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recipe_id"), rs.getString("recipeName")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList() throws DALException {
		return null;
	}

	@Override
	public void createProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {

	}

	@Override
	public void updateProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {

	}
}
