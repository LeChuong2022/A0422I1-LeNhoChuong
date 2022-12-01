package product_management.repository;

import product_management.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product p);

    void edit(Product p);

    void remove(String id);

    List<Product> findByName(String name);

    Product findById(String id);

}
