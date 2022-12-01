package product_management.repository;

import product_management.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("P1", "IPhone14", 1000, "Còn các màu xanh", "Apple"));
        productList.add(new Product("P2", "IPhone13", 900, "Còn các màu đỏ", "Apple"));
        productList.add(new Product("P3", "IPhone12", 800, "Còn các màu tím", "Apple"));
        productList.add(new Product("P4", "IPhone11", 700, "Còn các màu vàng", "Apple"));
        productList.add(new Product("P5", "Samsung S7", 600, "Còn các màu xanh", "Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product p) {
        productList.add(p);
    }

    @Override
    public void edit(Product p) {
        for (Product p1 : productList) {
            if (p1.getId().equals(p.getId())) {
                p1.setName(p.getName());
                p1.setPrice(p.getPrice());
                p1.setDescription(p.getDescription());
                p1.setManufacture(p.getManufacture());
            }
        }
    }

    @Override
    public void remove(String id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(i);
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name))
                productList1.add(productList.get(i));
        }
        return productList1;
    }

    @Override
    public Product findById(String id) {
        Product product = new Product();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().contains(id))
                product = productList.get(i);
        }
        return product;
    }
}
