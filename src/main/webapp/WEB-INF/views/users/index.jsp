<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Users list</h1>

<c:if test="${not empty users}">
    <c:forEach var="user" items="${users}">

        <c:out value="${user.getId()}" />
        <c:out value="${user.getName()}" />
        <c:out value="${user.getEmail()}" />
        <a href="<c:url value="/users/edit/${user.getId()}"/>">Edit user</a>
        <form:form method="delete" action="/users/${user.getId()}">
            <input type="submit" value="Delete user"/>
        </form:form>
        <br/>
    </c:forEach>
</c:if>


<a href="<c:url context="/" value="/users/new"/>">Create new user</a>