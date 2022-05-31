package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductI {
    void add(Product product) throws SQLException;

    Product findById(int id);

   public   List<Product> selectAll();

    boolean delete(int id) throws SQLException;

    void update(Product product) throws SQLException;

    List<Product> findByName(String key);


}
