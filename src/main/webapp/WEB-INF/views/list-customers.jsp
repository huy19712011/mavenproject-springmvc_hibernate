<%-- 
    Document   : list-customers
    Created on : Jul 31, 2021, 11:09:36 PM
    Author     : huynq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" 
              href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </head>
    <body>
        
        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Manager</h2>
            </div>
        </div>
        
        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>
                    
                    <c:forEach var="tempCustomer" items="${customers}">
                        <tr>
                            <td>${tempCustomer.firstName}</td>
                            <td>${tempCustomer.lastName}</td>
                            <td>${tempCustomer.email}</td>
                        </tr>
                    </c:forEach>
                    
                </table>
            </div>
        </div>
        
    </body>
</html>
