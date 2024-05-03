<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uploaded Recipe Information</title>
    <style>
        html {
          height: 100%;
        }

        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: url('images/backgrndimg.jpeg') center center fixed;
            background-size: cover;
            animation: fadeIn 2s ease; /* Add fade-in animation */
            overflow: scroll;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .container {
            max-width: 600px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            animation: slideIn 2s ease;
            position:absolute;
            top: 20px;
        }

        @keyframes slideIn {
            from {
                margin-top: -50px;
                opacity: 0;
            }
            to {
                margin-top: 0;
                opacity: 1;
            }
        }
        
        h2 {
            color: #00FF00; /* Green color for the title */
            text-align: center;
        }

        .recipe-card {
            display: flex;
            border: 1px solid #00FF00; /* Green border for the recipe cards */
            border-radius: 10px;
            overflow: hidden;
            margin-top: 20px;
            color: #FFFFFF; /* White text color for recipe details */
            animation: fadeInCard 2s ease; /* Add fade-in animation for cards */
        }

        @keyframes fadeInCard {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .recipe-card img {
            max-width: 200px;
            object-fit: cover;
            border-right: 1px solid #00FF00; /* Green border for the image */
        }

        .recipe-details {
            font-size: 30px;
            padding: 20px;
        }

        h3 {
            color: #00FF00; /* Green color for recipe names */
        }
        
        h5{
        	color: #00FF00;
        	font-size: 15px;
        }

        p {
            margin: 0 0 10px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Uploaded Recipe Information</h2>
        <c:forEach var="recipe" items="${recipeList}">
            <div class="recipe-card">
                <div class="recipe-details">
                    <h3>${recipe.recipename}</h3>
                    <p>Recipe Ingredients:</p>
                    <p>${recipe.recipeing}</p>
                    <p>Recipe Procedure:</p>
                    <p>${recipe.recipepro}</p>
                   	<h5>Upload by: ${recipe.username}</h5>                 
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
