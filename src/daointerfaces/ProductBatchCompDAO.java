package daointerfaces;

import java.util.List;

import dto.ProductBatchCompDTO;

public interface ProductBatchCompDAO {
	ProductBatchCompDTO getProductBatchComp(int pbId, int rbId) throws DALException;
	List<ProductBatchCompDTO> getProductBatchCompList(int pbId) throws DALException;
	List<ProductBatchCompDTO> getProductBatchCompList() throws DALException;
	void createProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException;
	void updateProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException;
}

