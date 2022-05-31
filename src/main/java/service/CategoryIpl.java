package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryIpl implements CategoryI {
    protected Connection getConnection() {
      Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void add(Category category) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into category(id,name)values (?,?)");) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public Category findById(int id) {
        Category category = new Category();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select id,name from category where id =?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {

        }
        return category;
    }

    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from category")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name) {

                });
            }
        } catch (SQLException e) {
        }
        return categoryList;

    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from category where id = ?");) {
            statement.setInt(1, id);
            if (statement.executeUpdate() > 0) {
                rowDeleted = true;
            } else {
                rowDeleted = false;
            }
        }
        return rowDeleted;

    }

    @Override
    public void update(Category category) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("update category set name= ? where id = ?;");) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            statement.executeUpdate();
        }


    }

    @Override
    public List<Category> findByName(String key) {
            List<Category> categoryList = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("select *from category where name like ?");) {
                preparedStatement.setString(1, "%" + key + "%");
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    categoryList.add(new Category(id, name));
                }
            } catch (SQLException e) {
            }
            return categoryList;

    }
}







