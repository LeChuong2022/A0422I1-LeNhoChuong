package ss12_java_collection_framework.exercise.luyen_tap_su_dung_ArrayList_LinkedList;

public class Product {
    private int id;
    private String name;
    private long price;

    public Product() {
    }

    public Product(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\tid=" + id +
                "\tname='" + name + "'" + "\tprice= " + price +
                '}' + "\n";
    }
}
