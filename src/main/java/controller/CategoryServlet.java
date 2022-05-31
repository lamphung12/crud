package controller;

import model.Category;
import service.CategoryIpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
   CategoryIpl cate = new CategoryIpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if(action==null){
           action = "";
        }
        switch (action){
            default:
                showList(request,response);
        }
      request.getRequestDispatcher("product/list.jsp").forward(request,response);

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = cate.selectAll();
        request.setAttribute("ds",categoryList);
        request.getRequestDispatcher("product/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
