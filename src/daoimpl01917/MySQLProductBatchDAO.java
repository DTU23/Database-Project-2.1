package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchDAO;
import dto01917.ProductBatchDTO;

public class MySQLProductBatchDAO implements ProductBatchDAO {

	@Override
	public ProductBatchDTO getProductBatch(int pbId) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductBatchDTO> getProductBatchList() throws DALException {
		List<ProductBatchDTO> list = new ArrayList<ProductBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM product_batch_list;");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProductBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recipe_id"), rs.getString("recipeName")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProductBatch(ProductBatchDTO productbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductBatch(ProductBatchDTO productbatch) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
