<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${flashMessage != null}">
    <div class="message">${flashMessage}</div>
</c:if>

<div style="font-size: 16px; font-weight: bold; padding: 15px 0px 15px 0px">
    Custom giving site for ${site.name}
</div>

<div class="row">
    <div class="col-md-4">
        <c:forEach items="${box1}" var="rubric">
            <div style="background: #eee; font-size: 16px; font-weight: bold">${rubric.title}</div>
            <div style="background: white">${rubric.body}</div>
        </c:forEach>
    </div>
    <div class="col-md-4">
        <c:forEach items="${box2}" var="rubric">
            <div style="background: #eee; font-size: 16px; font-weight: bold">${rubric.title}</div>
            <div style="background: white">${rubric.body}</div>
        </c:forEach>
    </div>
    <div class="col-md-4">
        <c:forEach items="${box3}" var="rubric">
            <div style="background: #eee; font-size: 16px; font-weight: bold">${rubric.title}</div>
            <div style="background: white">${rubric.body}</div>
        </c:forEach>
    </div>
</div>
