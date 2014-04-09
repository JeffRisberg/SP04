<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${flashMessage != null}">
    <div class="message">${flashMessage}</div>
</c:if>

<c:if test="${not empty site.name}">
    <div style="font-size: 16px; font-weight: bold; padding: 15px 0px 15px 0px">
        Custom giving site for ${site.name}
    </div>
</c:if>
<c:if test="${empty site}">
    <div style="font-size: 16px; font-weight: bold; padding: 15px 0px 15px 0px">
        Page not found
    </div>
</c:if>

<div class="row">
    <c:forEach items="${boxes0}" var="box">
        <div class="col-md-${box.width}">
            <c:forEach items="${box.rubrics}" var="rubric">
                <a href="<c:url value="/rubric/edit/${rubric.id}?finalURL=/page/${site.id}" />"
                   style="position:absolute; right: 0px; top:0px">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
                <c:if test="${not empty rubric.title}">
                    <div style="background: #eee; font-size: 16px; font-weight: bold">${rubric.title}</div>
                </c:if>
                <c:if test="${not empty rubric.body}">
                    <div style="background: white">${rubric.body}</div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
    <div style="clear:both"></div>
</div>

<div class="row">
    <c:forEach items="${boxes1}" var="box">
        <div class="col-md-${box.width}">
            <c:forEach items="${box.rubrics}" var="rubric">
                <a href="<c:url value="/rubric/edit/${rubric.id}?finalURL=/page/${site.id}" />"
                   style="position:absolute; right: 0px; top:0px">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
                <c:if test="${not empty rubric.title}">
                    <div style="background: #eee; font-size: 16px; font-weight: bold">${rubric.title}</div>
                </c:if>
                <c:if test="${not empty rubric.body}">
                    <div style="background: white">${rubric.body}</div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
    <div style="clear:both"></div>
</div>
