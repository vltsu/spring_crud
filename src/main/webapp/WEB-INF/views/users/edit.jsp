<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>User editing</h1>
<form:form method="put" action="/users/edit/${user.getId()}" modelAttribute="user">
    <t:insertDefinition name="userForm"/>
</form:form>