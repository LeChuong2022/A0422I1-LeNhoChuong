package ss17_io_binary_file_and_serialization.exercise.quan_ly_luu_ra_file_nhi_phan;

import java.io.Serializable;

public class ProductList implements Serializable {
    private int id;
    private String nameProduct;
    private String manufacture;
    private long price;

    public ProductList() {
    }

    public ProductList(int id, String nameProduct, String manufacture, long price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.manufacture = manufacture;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", \tnameProduct='" + nameProduct + '\'' +
                ", \tmanufacture='" + manufacture + '\'' +
                ", \tprice=" + price +
                '}';
    }
}
