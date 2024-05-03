<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Uploader</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<style>
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: #000 url('images/backgrndimg.jpeg') fixed;
    background-size: cover;
    animation: fadeIn 2s ease-in-out;
}

@keyframes fadeIn {
    0% {
        opacity: 0;
    }
    100% {
        opacity: 1;
    }
}

.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    border-radius: 10px;
}

form {
    display: flex;
    flex-direction: column;
}

h2 {
    color: #00FF00;
    text-align: center;
}

.form-group {
    margin-bottom: 20px;
}

label {
    font-weight: bold;
    color: #00FF00;
}

input,
textarea,
button {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 10px;
    border: 1px solid #4CAF50;
    border-radius: 10px;
    background-color: rgba(0, 0, 0, 0.5); /* Adjust the alpha value to control the input background opacity */
    color: #fff;
}

input[type="file"] {
    margin-top: 5px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: #ffffff;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

</style>

<div class="container">
    <form action="RecipeServlet" method="post" enctype="multipart/form-data">
        <h2>RecipeUploader</h2>
        <div class="form-group">
            <label for="recipeName">Recipe Name</label>
            <input type="text" id="recipeName" name="recipeName" required>
        </div>
        <div class="form-group">
            <label for="ingredients">Recipe Ingredients</label>
            <textarea id="ingredients" name="ingredients" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="procedure">Recipe Making Procedure</label>
            <textarea id="procedure" name="procedure" rows="6" required></textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Upload Recipe">
        </div>
    </form>
</div>

</body>
</html>
