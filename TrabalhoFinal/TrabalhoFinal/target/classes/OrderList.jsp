<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>SWII5- Trabalho Final - Marcelo Marques CB3005631</title>
</head>
<body>
	<center>
		<h1>SWII5- Trabalho Final - Marcelo Marques CB3005631</h1>
        <h2>
        	
        	<a href="OrderForm.jsp">AddOrdens</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	<a href="http://localhost:8080/Bookstore/list">Voltar</a>
        	
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Ordens</h2></caption>
            <tr>
                <th>ID</th>
                <th>order_no</th>
                <th>purch_amt</th>
                <th>ord_date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="order" items="${listCustomer}">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.cust_name}" /></td>
                    <td><c:out value="${order.city}" /></td>
                    <td><c:out value="${order.grade}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${order.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${order.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
