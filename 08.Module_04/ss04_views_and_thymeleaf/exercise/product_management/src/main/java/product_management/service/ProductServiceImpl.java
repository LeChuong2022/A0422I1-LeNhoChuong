package product_management.service;

import product_management.bean.Product;
import product_management.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    @Qualifier("repo1")
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    @Override
    public void create(Product p) {
        productRepository.create(p);
    }

    @Override
    public void edit(Product p) {
        productRepository.edit(p);
    }

    @Override
    public void remove(String id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

}
