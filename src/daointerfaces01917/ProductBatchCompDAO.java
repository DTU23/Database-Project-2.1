package daointerfaces01917;

import java.util.List;

import dto01917.ProductBatchCompDTO;

public interface ProductBatchCompDAO {
	ProductBatchCompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException;
	List<ProductBatchCompDTO> getProductBatchCompList(int pbId) throws DALException;
	List<ProductBatchCompDTO> getProductBatchCompList() throws DALException;
	void createProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException;
	void updateProductBatchComp(ProductBatchCompDTO productbatchcomponent) throws DALException;
}

