<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Desc: result.jsp
  User: <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
  Date: 2019-08-07 18:28
  Version: 1.0.0
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>${requestScope.message}</label><br>
<c:if test="${requestScope.show != false || requestScope.show == NULL}">
    ${requestScope.entity.name}, ${requestScope.entity.code}, ${requestScope.entity.phone}, ${requestScope.entity.deptName}, ${requestScope.entity.title}
    <a href="${pageContext.request.contextPath}/user/edit?id=${requestScope.entity.id}">点击编辑</a>
</c:if>
</body>
</html>
