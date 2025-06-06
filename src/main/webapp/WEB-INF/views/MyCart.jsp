<%@page import="com.bean.EcomProductCartBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        img.product-img {
            width: 80px;
            height: auto;
            border-radius: 8px;
        }
        .action-links a {
            margin: 0 5px;
        }
        footer {
            background-color: #343a40;
            color: white;
            padding: 15px 0;
        }
    </style>
</head>
<body>

<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark px-4">
    <a class="navbar-brand font-weight-bold" href="ehome">E-Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item <%= request.getRequestURI().contains("ehome") ? "active" : "" %>">
                <a class="nav-link" href="ehome">Home</a>
            </li>
            <li class="nav-item <%= request.getRequestURI().contains("userproducts") ? "active" : "" %>">
                <a class="nav-link" href="userproducts">Products</a>
            </li>
            <li class="nav-item <%= request.getRequestURI().contains("mycart") ? "active" : "" %>">
                <a class="nav-link" href="mycart">My Cart</a>
            </li>
            <li class="nav-item <%= request.getRequestURI().contains("inputmail") ? "active" : "" %>">
                <a class="nav-link" href="inputmail">Checkout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-danger font-weight-bold" href="logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<!-- Main Content -->
<div class="container mt-5">
    <h2 class="mb-4 text-center">🛒 My Shopping Cart</h2>
    <%
        List<EcomProductCartBean> products = (List<EcomProductCartBean>) request.getAttribute("products");
        Float Total_Price = 0.0f;
    %>

    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped bg-white">
            <thead class="thead-dark">
                <tr>
                    <th>#</th>
                    <th>Product</th>
                    <th>Image</th>
                    <th>Price (₹)</th>
                    <th>Qty</th>
                    <th>Total</th>
                    <th>Update Qty</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
            <%
                for(EcomProductCartBean p : products) {
                    float total = p.getQty() * p.getPrice();
                    Total_Price += total;
            %>
                <tr>
                    <td><%=p.getCartId() %></td>
                    <td><%=p.getProductName() %></td>
                    <td><img src="<%=p.getProductImagePath() %>" alt="Product Image" class="product-img" /></td>
                    <td>₹<%=p.getPrice() %></td>
                    <td><%=p.getQty() %></td>
                    <td>₹<%=total %></td>
                    <td class="action-links">
                        <a href="minusqty?cartId=<%=p.getCartId() %>" class="btn btn-sm btn-outline-secondary">-</a>
                        <a href="plusqty?cartId=<%=p.getCartId() %>" class="btn btn-sm btn-outline-primary">+</a>
                    </td>
                    <td>
                        <a href="removecartitem?cartId=<%=p.getCartId() %>" class="btn btn-sm btn-danger">Remove</a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>

    <div class="text-right">
        <h4 class="mt-4">Subtotal: ₹<%=Total_Price %></h4>
        <% session.setAttribute("totalPrice", Total_Price); %>
        <a href="inputmail" class="btn btn-success mt-3">Proceed to Checkout</a>
        <a href="userproducts" class="btn btn-outline-dark mt-3">Back to Products</a>
    </div>
</div>

<!-- Footer -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<footer class="bg-dark text-white mt-5">
    <div class="container py-5">
        <div class="row">
            <!-- About Section -->
            <div class="col-md-4">
                <h5>About E-Shop</h5>
                <p>
                    E-Shop is your one-stop online store for electronics, fashion, and more.  
                    We deliver quality products with fast and secure service.
                </p>
            </div>

            <!-- Quick Links -->
            <div class="col-md-4">
                <h5>Quick Links</h5>
                <ul class="list-unstyled">
                    <li><a href="ehome" class="text-white text-decoration-none">Home</a></li>
                    <li><a href="userproducts" class="text-white text-decoration-none">Products</a></li>
                    <li><a href="mycart" class="text-white text-decoration-none">My Cart</a></li>
                    <li><a href="inputmail" class="text-white text-decoration-none">Checkout</a></li>
                    <li><a href="logout" class="text-white text-decoration-none">Logout</a></li>
                </ul>
            </div>

            <!-- Contact Info -->
            <div class="col-md-4">
                <h5>Contact Us</h5>
                <p>
                    📍 Surat, Gujarat, India<br>
                    📞 +91 98765 43210<br>
                    ✉️ support@eshop.com
                </p>
                <div>
                    <a href="#" class="text-white me-3"><i class="bi bi-facebook"></i></a>
                    <a href="#" class="text-white me-3"><i class="bi bi-twitter"></i></a>
                    <a href="#" class="text-white"><i class="bi bi-instagram"></i></a>
                </div>
            </div>
        </div>
        <hr class="border-light mt-4">
        <div class="text-center">
            &copy; 2025 E-Shop. All rights reserved.
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
