package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.IDaoProduct;
import model.ModelProduct;

@Service("svrprod")
public class ServiceProduct implements IServiceProduct {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoprod")
    private IDaoProduct dao;

    @Override
    public ModelProduct getProduct(String name) {
        ModelProduct product = dao.getProduct(name);
        return product;
    }

    @Override
    public ModelProduct getException(String name) throws Exception {
        ModelProduct product = dao.getException(name);
        return product;
    }

    @Override
    public void getNone() {
        dao.getProduct("none");
    }
}
