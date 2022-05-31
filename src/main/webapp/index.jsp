<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-2">
          <div class="fa fa-envelope">hello.lam@gmail.com</div>

        </div>
        <div class="col-3">
            Free Shipping for all Order of $99
        </div>
        <div class="col-3">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="col-2">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
        </div>
        <div class="col-2">Login</div>
        <div class="col-3 mt-3">
            <img src="img/logo.png" alt="">
        </div>
        <div class="col-6 mt-3">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Homes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Shop <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/ProductServlet?action=create">Create Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Blogs</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Contact</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
        <div class="col-3 >
           <a href=""><i class="fa fa-heart"></i> <span>1</span></a>
           <a href=""><i class="fa fa-shopping-bag"></i> <span>3</span></a>
           <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>

    </div>
</div>
<%--////content--%>
<section class="hero  mt-3">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-expanded="false">
                       AllCategory
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                          <c:forEach items="${category}" var="ca">
                              <h5><a href="/homeServlet?cId=${ca.id}"> ${ca.name}</a></h5>
                           </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <form class="form-inline my-2 my-lg-0" action="/homeServlet">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search"  name="key">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>

                <div id="carouselExampleIndicators" class="carousel slide mt-3" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="img/banner/banner-1.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/banner/banner-2.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="img/hero/banner.jpg" class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="row">
                <c:forEach items="${product}" var="pr">
                  <div class="col-3">
                   <div class="card" style="width: 18rem;">
                     <img src="img/categories/cat-1.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                           <h5 class="card-title">${pr.name}</h5>
                           <p class="card-text">Mô tả sản phẩm</p>
                           <p class="card-text">${pr.price}</p>
                        <div class="btn-group" role="group" aria-label="Basic example">
                                <a class="btn btn-secondary" href="/ProductServlet?action=view&id=${pr.id}">View</a>
                                <a  class="btn btn-secondary">Edit</a>
                                <a class="btn btn-danger" href="/ProductServlet?action=delete&id=${pr.id}">Delete</a>
                  </div>
              </div>
          </div>
                 </div>
                </c:forEach>

            </div>
        </div>

    </div>

</div>





</body>
</html>