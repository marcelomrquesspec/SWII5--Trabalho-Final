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
		<c:if test="${order != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${order == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${order != null}">
            			Edit Salesman
            		</c:if>
            		<c:if test="${order == null}">
            			AdicionarOrdem
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${order != null}">
        			<input type="hidden" name="id" value="<c:out value='${order.id}' />" />
        		</c:if>            
            <tr>
                <th>OrdemNro: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${order.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Purch_AMT: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${order.city}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>OrdenDATA: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${order.commission}' />"
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
