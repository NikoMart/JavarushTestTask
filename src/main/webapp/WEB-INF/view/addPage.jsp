<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Adding new user</title>
</head>
<body>
<center>
    <h1>Create new User</h1>

    <c:url var="saveUrl" value="/add" />
    <form:form modelAttribute="user" method="POST" action="${saveUrl}">
        <table>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name" required="required" pattern="[A-Za-z0-9]{1,25}"/></td>
            </tr>

            <tr>
                <td><form:label path="age">Age:</form:label></td>
                <td><form:input path="age" type="nimber" pattern="[0-9]{3}"/></td>
            </tr>

            <tr>
                <td><form:label path="Admin">is Admin:</form:label></td>
                <td><form:checkbox path="Admin"></form:checkbox></td>
            </tr>
        </table>

        <input type="submit" value="Save" />
    </form:form>

</center>
</body>
</html>