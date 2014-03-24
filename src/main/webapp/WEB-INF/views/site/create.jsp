<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="saveUrl" value="/site/save"/>
<form:form method="post" action="${saveUrl}">
    <form:hidden path="id"/>
    <div>
        Name:<br/>
        <form:input path="name"/>
    </div>

    <input type="submit" value="Submit">
</form:form>
