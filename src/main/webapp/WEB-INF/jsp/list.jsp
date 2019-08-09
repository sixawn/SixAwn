<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Desc: index.jsp
  User: <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
  Date: 2019-08-07 18:28
  Version: 1.0.0
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="1" cellspacing="0" align="center">
        <thead>
            <tr>
                <th width="100px">编  号</th>
                <th width="100px">姓  名</th>
                <th width="150px">工  号</th>
                <th width="200px">手  机</th>
                <th width="200px">科  室</th>
                <th width="200px">职  称</th>
                <th width="200px">操  作</th>
            </tr>
        </thead>
        <tbody align="center">
        <c:forEach items="${requestScope.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.code}</td>
                <td>${user.phone}</td>
                <td>${user.deptName}</td>
                <td>${user.title}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">编辑</a> |
                    <a href="${pageContext.request.contextPath}/user/delete?id=${user.id}&key=${requestScope.key}">删除</a> |
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
