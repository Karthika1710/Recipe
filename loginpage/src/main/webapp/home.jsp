<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe-Rover</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background-image: url('images/backgrndimg.jpeg'); /* Add the path to your background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            color: white; /* Set text color to contrast with the background */
            height: 100vh; /* Set a fixed height to ensure the background image covers the entire viewport */
        }

        .navbar {
            background-color: #000; /* Black color */
            overflow: hidden;
            animation: fadeIn 1s ease; /* Fade-in animation */
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .logo {
            float: left;
            font-size: 40px;
            color: white;
            padding: 15px;
        }

        .nav-links {
            float: right;
        }

        .nav-links a, button {
            font-size: 20px;
           
            margin-right:50px;
            display: inline-block;
            color: white;
            text-align: center;
            text-decoration: none;
            padding: 14px 16px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease; /* Smooth background color transition */
        }

        .nav-links form {
            display: inline-block;
            margin: 0;
        }

        .navbar button {
            background-color: black; /* Green color for the button */
        }

        .navbar button:hover {
            background-color: #357a38; /* Darker green on hover */
        }

        .welcome-section {
            font-style:italic;
            font-size:40px;
            text-align: center;
            margin: 100px;
        }

        h1 {
            color:#00FF00 ; /* Green color */
        }

        #username {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="logo">Recipe Rover</div>
        <div class="nav-links">
            <form action="recipedis" method="get">
                <button type="submit">Recipes</button>
            </form>
            <form action="logout" method="get">
                <button type="submit">Logout</button>
            </form>
        </div>
    </div>

    <div class="welcome-section">
        <h1>Welcome, <span id="username">${name}!!<br> Let's Start new recipes</span>!</h1>
    </div>
</body>
</html>
