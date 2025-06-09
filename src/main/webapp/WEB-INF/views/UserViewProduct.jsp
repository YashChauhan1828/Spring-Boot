<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.EcomReviewBean" %>
<%
    List<EcomReviewBean> reviews = (List<EcomReviewBean>) request.getAttribute("reviews");
    if (reviews == null) { reviews = new java.util.ArrayList<>(); }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #121212;
            color: #fff;
            font-family: 'Segoe UI', sans-serif;
        }
        .product-card {
            background-color: #1e1e1e;
            border-radius: 12px;
            max-width: 700px;
            margin: 60px auto;
            box-shadow: 0 0 20px rgba(255, 255, 255, 0.05);
            padding: 30px;
        }
        .product-image {
            width: 200px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0 0 8px rgba(255, 255, 255, 0.1);
        }
        .product-title {
            font-size: 1.8rem;
            font-weight: bold;
            margin-top: 20px;
        }
        .product-price {
            font-size: 1.4rem;
            color: #4caf50;
        }
        .product-category {
            font-size: 1rem;
            color: #aaa;
        }
        .product-description {
            font-size: 1rem;
            color: #ddd;
            margin-top: 15px;
        }
        .btn-outline-light:hover {
            color: #121212;
            background-color: #fff;
        }
        .action-buttons {
            margin-top: 20px;
        }
        .review-form, .reviews {
            margin-top: 40px;
        }
        .review-card {
            background-color: #2a2a2a;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 15px;
            box-shadow: 0 0 5px rgba(255,255,255,0.05);
        }
        .review-rating {
            color: #f4c430;
        }
        .form-control, .form-select {
            background-color: #1e1e1e;
            color: #fff;
            border: 1px solid #444;
        }
        textarea::placeholder {
            color: #aaa;
        }
    </style>
</head>
<body>

<div class="product-card text-center">
    <img class="product-image" src="${product.productImagePath}" alt="${product.productName}">
    <div class="product-title">${product.productName}</div>
    <div class="product-price">₹ ${product.price}</div>
    <div class="product-category">Category: ${product.category}</div>

    <div class="product-description">
        <hr style="background-color:#333;">
        <p>This product is made with high-quality materials and is designed to meet your everyday needs. Experience excellence, comfort, and performance with every purchase.</p>
    </div>

    <div class="action-buttons">
        <a href="addtocart?productId=${product.productId}" class="btn btn-success">Add to Cart 🛒</a>
        <a href="userproducts" class="btn btn-outline-light ml-2">← Back to Products</a>
    </div>

    <!-- Review Submission -->
    <div class="review-form text-left mt-5">
        <h5>⭐ Submit Your Review</h5>
        <form action="addReview" method="post">
            <input type="hidden" name="productId" value="${product.productId}">
            <div class="form-group mt-3">
                <label for="rating">Rating</label>
                <select class="form-control" id="rating" name="rating" required>
                    <option value="5">5 - Excellent ⭐⭐⭐⭐⭐</option>
                    <option value="4">4 - Good ⭐⭐⭐⭐</option>
                    <option value="3">3 - Average ⭐⭐⭐</option>
                    <option value="2">2 - Poor ⭐⭐</option>
                    <option value="1">1 - Bad ⭐</option>
                </select>
            </div>
            <div class="form-group mt-2">
                <label for="comment">Comment</label>
                <textarea class="form-control" name="comment" rows="3" placeholder="Share your experience..." required></textarea>
            </div>
            <button class="btn btn-primary mt-3" type="submit">Submit Review</button>
        </form>
    </div>

    <!-- Existing Reviews -->
    <div class="reviews text-left mt-5">
        <h5>📝 Customer Reviews</h5>
        <%
            if (reviews.isEmpty()) {
        %>
            <p class="text-muted">No reviews yet. Be the first to review this product.</p>
        <%
            } else {
                for (EcomReviewBean r : reviews) {
        %>
            <div class="review-card">
                <div class="review-rating">⭐ <%= r.getRating() %>/5</div>
                <div class="review-comment mt-1"><%= r.getComment() %></div>
                <div class="text-muted mt-1" style="font-size: 0.9rem;">Posted on <%= r.getCreatedAt() %></div>
            </div>
        <%
                }
            }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
