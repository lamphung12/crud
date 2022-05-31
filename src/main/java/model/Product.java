package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private Category categoryId;

    public Product(int id, String name, int price, Category cId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = cId;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
