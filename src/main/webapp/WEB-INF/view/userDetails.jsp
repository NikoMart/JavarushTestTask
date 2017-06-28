<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
        }

        th {
            background: Grey;
            color: white;
        }

        td, th {
            border: 1px solid gray;
            text-align: left;
            padding: 5px 5px;
        }
    </style>
</head>
<body>
<center>
    <h1>Users</h1>

    <a href="<c:url value='/add' />">ADD USER</a>
    <br>

    <c:url var="saveUrl" value="/filter"/>
    <form:form modelAttribute="user" method="POST" action="${saveUrl}">
        <table>
            <tr>
                <td><form:label path="name">Filter users by name:</form:label></td>
                <td><form:input path="name" required="required" value="${filter}" pattern="[A-Za-z0-9]{1,25}"/></td>
                <td>
                    <input type="submit" value="Filter"/>
                    <a href="<c:url value='/' />">Reset</a>
                </td>
            </tr>
        </table>

    </form:form>
    <br>
    <c:if test="${empty filter}">
        <c:if test="${pageNumber>1}">
            <a href="<c:url value='/page/${pageNumber-1}' />"><<< previous page</a>
        </c:if>

        <c:if test="${pageNumber<=1}">
            <<< previous page
        </c:if>
        [${pageNumber}]
        <c:if test="${fn:length(list)==5}">
            <a href="<c:url value='/page/${pageNumber+1}' />">next page >>></a>
        </c:if>

        <c:if test="${fn:length(list)<5}">
            next page >>>
        </c:if>
    </c:if>


    <table style="border: 2px solid;  text-align:center">
        <thead style="">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Admin</th>
            <th>Created Date</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td>
                    <input type="checkbox" disabled name="admin" <c:if test="${user.admin}">checked="checked"</c:if>/>
                </td>
                <td><c:out value="${user.createDate}"/></td>
                <td><a href="<c:url value='/edit/${user.id}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteUser/${user.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</center>
</body>
</html>