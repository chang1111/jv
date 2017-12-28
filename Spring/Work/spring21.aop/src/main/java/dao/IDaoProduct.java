package dao;

import model.ModelProduct;

public interface IDaoProduct {
    ModelProduct getProduct(String name);
    ModelProduct getException(String name) throws Exception;
}
