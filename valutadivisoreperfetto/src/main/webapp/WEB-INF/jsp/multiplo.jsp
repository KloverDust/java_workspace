<!-- multiplo.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Divisione Perfetta</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            text-align:
            center;
            color: #333;
        }
        p {
            font-size: 1.1em;
        }
        .btn-home {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background: #4CAF50;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-home:hover {
            background: #45a049;
            }
    </style>
</head>
<body>
<div class="container">
    <h1>Divisione Perfetta</h1>
    <p>Il numero <strong>${dividendo}</strong> è in effetti un multiplo del numero <strong>${divisore}</strong> e in esso è contenuto <strong>${quoziente}</strong> volte.</p>
    <a href="${pageContext.request.contextPath}/" class="btn-home">Torna alla Home</a>
</div>
</body>
</html>