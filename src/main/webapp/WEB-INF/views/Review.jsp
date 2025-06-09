<%@page import="com.bean.EcomReviewProductBean"%>
<%@page import="com.bean.EcomReviewBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.EcomReviewProductBean" %> <!-- Update with your actual bean -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Reviews</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #121212;
            color: #fff;
            font-family: 'Segoe UI', sans-serif;
        }
        .review-section {
            max-width: 800px;
            margin: 60px auto;
            padding: 20px;
            background-color: #1e1e1e;
            border-radius: 12px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.1);
        }
        .review-card {
            background-color: #2a2a2a;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 10px;
            box-shadow: 0 0 6px rgba(255, 255, 255, 0.05);
        }
        .review-rating {
            color: #fbc02d;
            font-size: 1.2rem;
        }
        .review-user {
            font-weight: bold;
            color: #90caf9;
        }
        .review-comment {
            margin-top: 10px;
            font-size: 1rem;
            color: #ddd;
        }
    </style>
</head>
<body>

<div class="review-section">
    <h3 class="text-center mb-4">🗣 Product Reviews</h3>
    <%
        List<EcomReviewProductBean> reviews = (List<EcomReviewProductBean>) request.getAttribute("reviews");
        if (reviews != null && !reviews.isEmpty()) {
            for (EcomReviewProductBean review : reviews) {
    %>
        <div class="review-card">
            <div class="review-user">👤 <img src="<%= review.getProductImagePath() %>" alt="Product Image" class="product-img" /></div>
            <div class="review-rating">
                Rating:
                <% for (int i = 1; i <= review.getRating(); i++) { %>
                    ⭐
                <% } %>
                (<%= review.getRating() %>/5)
            </div>
            <div class="review-comment">"<%= review.getComment() %>"</div>
        </div>
    <%
            }
        } else {
    %>
        <p class="text-center text-muted">No reviews available for this product yet.</p>
    <%
        }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
