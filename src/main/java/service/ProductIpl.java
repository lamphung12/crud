package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductIpl implements ProductI{
   CategoryIpl categoryIpl = new CategoryIpl();

    protected Connection getConnection() {
        Connection connection = null;
        try{ Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products?useSSL=false", "root", "123456");}
        catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
//
        return connection;
    }


    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(id,name,price,cId)values (?,?,?,?)");) {
            preparedStatement.setInt(1,product.getId());
           preparedStatement.setString(2, product.getName());
           preparedStatement.setInt(3,product.getPrice());
           preparedStatement.setInt(4,product.getCategoryId().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id =?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name");
                int price= rs.getInt("price");
                int categoryId = rs.getInt("cId");
                Category cate = categoryIpl.findById(categoryId);
                product =new Product(id,name,price,cate);
            }
        } catch (SQLException e) {

        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from product")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int cId = rs.getInt("cId");
                Category cate = categoryIpl.findById(cId);
                productList.add(new Product(id,name,price,cate));
            }
        } catch (SQLException e) {
        }
        return productList;

    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from product where id = ?");) {
            statement.setInt(1, id);
            if (statement.executeUpdate() > 0) {
                rowDelete = true;
            } else {
                rowDelete = false;
            }
        }
        return rowDelete;

    }

    @Override
    public void update(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("update product set name= ?,price=? where id = ?;");) {
            statement.setString(1, product.getName());
            statement.setInt(2,product.getPrice());
            statement.setInt(3, product.getId());
            statement.executeUpdate();
        }



    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from product where name like ?");) {
            preparedStatement.setString(1, "%" + key + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int cId = rs.getInt("cId");
                Category cate = categoryIpl.findById(cId);
                productList.add(new Product(id,name,price,cate));

            }
        } catch (SQLException e) {
        }
        return productList;
    }

    public List<Product> findByCategory(int cId) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from product where cId = ?");) {
            preparedStatement.setInt(1,cId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int categoryId = rs.getInt("cId");
                Category cate = categoryIpl.findById(categoryId);
                productList.add(new Product(id,name,price,cate));
            }
        } catch (SQLException e) {
        }
        return productList;
    }

}
