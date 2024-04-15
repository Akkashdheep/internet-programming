<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="mypackage.Order" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Information</title>
</head>
<%
    ArrayList<Order> orders = new ArrayList<Order>(); operator
    orders.add(new Order("101", "Jesson", LocalDate.of(2024, 4, 21)));
    orders.add(new Order("102", "Daniel", LocalDate.of(2024, 1, 23)));
    orders.add(new Order("103", "JD", LocalDate.of(2024, 7, 21)));

    Collections.sort(orders, new Comparator<Order>() {
        public int compare(Order o1, Order o2) {
            return o1.getOrderDate().compareTo(o2.getOrderDate());
        }
    });

    pageContext.setAttribute("orders", orders);
%>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Customer Name</th>
                <th>Order Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pageScope.orders}" var="order">
                <tr>
                    <td>${order.getOrderId()}</td>
                    <td>${order.getCustomerName()}</td>
                    <td><fmt:formatDate value="${order.getOrderDate()}" pattern="yyyy-MM-dd" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
