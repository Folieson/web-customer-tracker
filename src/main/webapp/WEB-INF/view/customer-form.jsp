<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 03.05.2020
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First Name:</label></td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName" class="error"/></td>
            </tr>
            <tr>
                <td><label>Last Name:</label></td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName" class="error"/></td>
            </tr>
            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save" onclick="vali"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>
