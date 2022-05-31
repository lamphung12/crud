package service;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface CategoryI {
    void add(Category category) throws SQLException;

    Category findById(int id);

    public List<Category> selectAll();

    boolean delete(int id) throws SQLException;

    void update(Category category) throws SQLException;

    List<Category> findByName(String key);
}
