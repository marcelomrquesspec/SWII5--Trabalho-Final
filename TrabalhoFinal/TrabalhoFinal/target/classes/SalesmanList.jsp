<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Salesman Store Application</title>
</head>
<body>
	<center>
		<h1>SWII5- Trabalho Final - Marcelo Marques CB3005631</h1>
        <h2>
        	<a href="new">Vendedores</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	&nbsp;&nbsp;&nbsp;
        	<a href="CustomerList.jsp">Clientes</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="http://localhost:8080/Bookstore/OrderList.jsp">OrdensDeVenda</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Vendedores</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>City</th>
                <th>Commission</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="salesman" items="${listSalesman}">
                <tr>
                    <td><c:out value="${salesman.id}" /></td>
                    <td><c:out value="${salesman.name}" /></td>
                    <td><c:out value="${salesman.city}" /></td>
                    <td><c:out value="${salesman.commission}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${salesman.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${salesman.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
