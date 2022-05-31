package controller;

import model.Category;
import model.Product;
import service.CategoryIpl;
import service.ProductIpl;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/homeServlet")
public class HomeServlet extends HttpServlet {
   ProductIpl productIpl = new ProductIpl();
   CategoryIpl categoryIpl = new CategoryIpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cId = request.getParameter("cId");
        String key = request.getParameter("key");
       RequestDispatcher requestDispatcher=  request.getRequestDispatcher("index.jsp");
        List<Category> categoryList = categoryIpl.selectAll();
        request.setAttribute("category",categoryList);
        List<Product> productList = productIpl.selectAll();
        if(cId !=null){
            productList=productIpl.findByCategory(Integer.parseInt(cId));
        }
        if(key !=null){
            productList=productIpl.findByName(key);

        }
        request.setAttribute("product",productList);
        requestDispatcher.forward(request,response);
    }
    public void destroy() {
    }
}