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
		ResultSet rs = Connector.doQuery("CALL get_batch_details_from_id = " + pbId);
		try {
			if (!rs.first()) throw new DALException("Produkt parti med " + pbId + " findes ikke");
			return new ProductBatchCompDTO (rs.getInt("pbId"), rs.getInt("rbId"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("oprId"));
		}
		catch (SQLException e) {throw new DALException(e); }

	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList(int pbId) throws DALException {
		List<ProductBatchCompDTO> list = new ArrayList<ProductBatchCompDTO>();
		ResultSet rs = Connector.doQuery("CALL get_batch_details_from_id("+pbId+");");
		try
		{
			while (rs.next())
			{
				list.add(new ProductBatchCompDTO(rs.getInt("pbId"), rs.getInt("rbId"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("oprId")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {
		Connector.doUpdate("CALL create_product_batch_from_recipe_id(" + productbatchcomponent.getPbId() + "," + productbatchcomponent.getRbId() + "," + productbatchcomponent.getTara() + "," + 
				productbatchcomponent.getNetto() + "," + productbatchcomponent.getOprId() + ");"); // rigtig CALL?
	}

	@Override
	public void updateProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException {
		Connector.doUpdate("CALL update_product_batch(" + productbatchcomponent.getPbId() + "," + productbatchcomponent.getRbId() + "," + productbatchcomponent.getTara() + "," + 
				productbatchcomponent.getNetto() + "," + productbatchcomponent.getOprId() + ");"); // rigtig CALL?
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}
}
