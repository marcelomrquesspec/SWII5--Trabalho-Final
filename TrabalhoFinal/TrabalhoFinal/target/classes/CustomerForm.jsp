<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Trabalho Final</title>
</head>
<body>
	<center>
		<h1>SWII5- Trabalho Final -Marcelo Marques CB3005631</h1>
        <h2>
        	<a href="new">Adicionar Ordens</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="http://localhost:8080/Bookstore/list">Voltar</a>
        	
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${customer != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${customer == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${customer != null}">
            			Edit Customer
            		</c:if>
            		<c:if test="${customer == null}">
            			Adicionar Clientes
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${customer != null}">
        			<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
        		</c:if>            
            <tr>
                <th>Cust_Name: </th>
                <td>
                	<input type="text" name="Nome" size="45"
                			value="<c:out value='${customer.cust_name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                	<input type="text" name="Grade" size="45"
                			value="<c:out value='${customer.city}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Grade: </th>
                <td>
                	<input type="text" name="OrdemData" size="5"
                			value="<c:out value='${customer.grade}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
