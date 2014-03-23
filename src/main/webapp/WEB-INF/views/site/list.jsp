<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${flashMessage != null}">
    <div class="message">${flashMessage}</div>
</c:if>

<div id="siteResults">
    <div class="list">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="site" items="${siteList}" varStatus="rowCounter">
                <tr class="${rowCounter.count % 2 == 0 ? 'even' : 'odd'}">
                    <td><a href="<c:url value="/site/show/${site.id}" />">${site.name}</a>
                    <td><a href="<c:url value="/site/edit/${site.id}" />">Edit</a>
                </tr>
            </c:forEach>
            <c:if test="${empty siteList}">
                <tr>
                    <td colspan="999">No sites found</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
