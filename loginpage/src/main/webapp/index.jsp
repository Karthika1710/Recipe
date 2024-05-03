<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Buttons</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column; /* Adjusted to stack elements vertically */
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #fafafa;
        }

        h1 {
        	margin-left:50px;
            font-family: "Arial", sans-serif;
            font-size: 60px;
            margin-bottom: 100px;
        }
        .whole{
        	margin-bottom: 10%;
        
        }

        .profile-container {
        margin-left:1%;
   display: grid;
  grid-template-columns: 1fr 1fr ;
  row-gap: 10px;
            
             /* Adjusted to evenly space elements horizontally */
            width: 50%;
        }

        .profile-button {
            width: 200px;
            height: 200px;
            border-radius: 15px;
            color: #fff;
            text-align: center;
            font-size: 18px;
            cursor: pointer;
            margin: 5px; /* Adjusted margin */
            transition: background-color 0.3s;
            overflow: hidden; /* Ensure that the image doesn't exceed the button boundaries */
            position: relative; /* Establish stacking context for absolute positioning */
        }

        .profile-button img {
            width: 100%; /* Make the image take 100% of the button's width */
            height: 100%; /* Make the image take 100% of the button's height */
            object-fit: cover; /* Maintain aspect ratio and cover the entire button */
            position: absolute; /* Position the image absolutely within the button */
            top: 0;
            left: 0;
        }

        .profile-button:hover {
            background-color: #2980b9;
        }

        #recipeuploading {
        	margin-right:70px;
            border: 3px solid green;
            box-shadow: 5px 5px 5px black;
        }

        #naiveusers {
            border: 2px solid #99ECFF;
            box-shadow: 5px 5px 5px black;
        }
    </style>
</head>
<body>
<div class="whole">
    <h1>Who you are?</h1>

    <div class="profile-container">
        <div class="profile-button" id="recipeuploading">
        <a href="logincook.jsp">
            <img src="images/cok.png" alt="Recipe Uploading">
            </a>
            
 
        </div>

        <div class="profile-button" id="naiveusers">
        <a href="login.jsp ">
            <img src="images/naivee.png" alt="Naive Users">
		</a>		
    </div>
 </div>

</body>
</html>
