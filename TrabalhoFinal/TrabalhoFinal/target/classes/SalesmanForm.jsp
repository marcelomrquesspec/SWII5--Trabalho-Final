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
        	
        	<a href="list">Listar Vendedores</a>
        	
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${salesman != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${salesman == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${salesman != null}">
            			Edit Salesman
            		</c:if>
            		<c:if test="${salesman == null}">
            			Adicionar Vendedor
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${salesman != null}">
        			<input type="hidden" name="id" value="<c:out value='${salesman.id}' />" />
        		</c:if>            
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="title" size="45"
                			value="<c:out value='${salesman.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                	<input type="text" name="author" size="45"
                			value="<c:out value='${salesman.city}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Commission: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${salesman.commission}' />"
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
