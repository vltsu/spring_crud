<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>New user creation</h1>
<form:form method="post" action="/users" modelAttribute="user">
    <t:insertDefinition name="userForm"/>
</form:form>