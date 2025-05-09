<!-- divisioneconresto.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Divisione con Resto</title>
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
            text-align: center;
            color: #c0392b;
        }
        p {
            font-size: 1.1em;
        }
        .btn-home {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-home:hover {
            background: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Divisione con Resto</h1>
    <p>Il numero <strong>${dividendo}</strong> diviso per <strong>${divisore}</strong> produce un resto pari a <strong>${resto}</strong>.</p>
    <a href="${pageContext.request.contextPath}/" class="btn-home">Riprova con altri numeri</a>
</div>
</body>
</html>