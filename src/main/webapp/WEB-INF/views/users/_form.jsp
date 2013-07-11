<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
    .errorblock, .error {
        color: red;
    }
</style>
<form:errors path="*" cssClass="errorblock" element="div" />
<br/>
<form:label path="name">Name</form:label>
<form:input path="name"/>
<form:errors path="name" cssClass="error" />
<br/>
<form:label path="email">email</form:label>
<form:input path="email"/>
<form:errors path="email" cssClass="error" />
<br/>
<input type="submit"/>
