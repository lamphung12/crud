package controller;

import model.Category;
import model.Product;
import service.CategoryIpl;
import service.ProductIpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductIpl productServlet = new ProductIpl();
    CategoryIpl cate = new CategoryIpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
               showCreatForm(request,response);
               break;
            case "view":
                showView(request,response);
                break;
            case "delete":
                try {
                    showDelete(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case"edit":
                showEdit(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = cate.selectAll();
        request.setAttribute("category",categoryList);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("product/edit.jsp").forward(request,response);
    }


    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productServlet.delete(id);
        List<Product> productList =productServlet.selectAll();
        request.setAttribute("product",productList);
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = cate.selectAll();
        request.setAttribute("category",categoryList);
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = productServlet.findById(id);
        request.setAttribute("product",products);
        request.getRequestDispatcher("product/view.jsp").forward(request,response);

    }

    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = cate.selectAll();
        request.setAttribute("category",categoryList);
        request.getRequestDispatcher("product/createProduct.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productServlet.selectAll();
        request.setAttribute("product",productList);
        request.getRequestDispatcher("product/listProduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action==null){
            action = "";
        }
        switch (action){
            case "create":
                try {
                    create(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case"edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                showList(request,response);
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int id = Integer.parseInt(request.getParameter("id"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        Category category = cate.findById(cId);
       productServlet.update(new Product(id,name,price,category));
       response.sendRedirect("/homeServlet");


    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name =request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category= cate.findById(categoryId);
        productServlet.add(new Product(0,name,price,category));
        response.sendRedirect("/homeServlet");
    }


}
