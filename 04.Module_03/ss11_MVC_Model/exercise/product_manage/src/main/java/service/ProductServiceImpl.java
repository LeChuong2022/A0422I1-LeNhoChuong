package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Apple14", 1000, 100));
        products.add(new Product(2, "Apple13", 900, 20));
        products.add(new Product(3, "SamSungS22", 800, 35));
        products.add(new Product(4, "SamSungS21", 600, 40));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }


    @Override
    public void update(int id, Product product) {
        products.set(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public int listSize() {
        return products.size();
    }

    @Override
    public void modifyId(int id) {
        for (int i = products.size(); i > id; i--) {
            products.get(i - 1).setId(i);
        }
    }

    public String getName(int id) {
        return products.get(id).getName();
    }

}
