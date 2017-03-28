package daointerfaces01917;

import java.util.List;

import dto01917.ProductBatchDTO;

public interface ProductBatchDAO {
	ProductBatchDTO getProductBatch(int pbId) throws DALException;
	List<ProductBatchDTO> getProductBatchList() throws DALException;
	void createProductBatch(ProductBatchDTO productbatch) throws DALException;
	void updateProductBatch(ProductBatchDTO productbatch) throws DALException;
}