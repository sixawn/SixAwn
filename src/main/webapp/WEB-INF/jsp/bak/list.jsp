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
    <style type="text/css">

        table{
            border-collapse:collapse;
            table-layout:fixed;
            border-radius:5px;
            overflow:hidden;
            margin: 10px auto;
            border:2px solid #70aefb ;

            /*color: #c7dafb;*/
        }
        table th {
            background-color: #328ef4;
        }
        table td,th{
            /* padding: 5px;
            width: 33%; */
            text-align: center;
            border:1px solid #70aefb ;
            vertical-align:middle;
            /* font-size: 15px; */
            /*width: 80%;*/
        }

        .table-color-green {
            background-color: green;

        }

        .table-color-grey{

            background-color:  #696969;
        }

        .table-color-black{

            /*background-color: black;*/
        }

        .jt-up-color{
            color:red;
        }

        .parent-position{
            position: relative;
        }

        .child-position{
            position: absolute;
            right: 0;
            bottom: 0;
        }

        .main-font{
            font-size: 23px;
        }
    </style>
</head>
<body>
    <table border="1" cellspacing="0" align="center">
        <thead>
            <tr>
                <th width="100px">编  号</th>
                <th width="100px">乡  镇</th>
                <th width="100px">行政村/社区</th>
                <th width="100px">姓  名</th>
                <th width="200px">手  机</th>
                <th width="200px">身份证号码</th>
                <th width="200px">目前在湖南居住地</th>
                <th width="200px">体温（℃）</th>
                <th width="200px">有无咳嗽、胸闷等不适症状</th>
                <th width="200px">湖北居住地</th>
                <th width="200px">离开湖北所在地级市</th>
                <th width="200px">离开湖北日期</th>
                <th width="200px">车次/航班/汽车/自驾*</th>
                <th width="200px">沿途是否停留？如是，停留地点</th>
                <th width="200px">同行人员姓名</th>
                <th width="200px">操  作</th>
            </tr>
        </thead>
        <tbody align="center">
        <c:forEach items="${requestScope.list}" var="user">
            <tr>
                <td>1</td>
                <td>user.name}</td>
                <td>${user.code}</td>
                <td>${user.phone}</td>
                <td>${user.deptName}</td>
                <td>${user.title}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/health/edit?id=${user.id}">编辑</a> |
                    <a href="${pageContext.request.contextPath}/health/delete?id=${user.id}&key=${requestScope.key}">删除</a> |
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>1</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.name</td>
            <td>user.code</td>
            <td>user.phone</td>
            <td>user.deptName</td>
            <td>user.title</td>
            <td>user.title</td>
            <td>
                <a href="${pageContext.request.contextPath}/health/edit?id=${user.id}">编辑</a> |
                <a href="${pageContext.request.contextPath}/health/delete?id=${user.id}&key=${requestScope.key}">删除</a> |
            </td>
        </tr>
        </tbody>
    </table>
</body>
</html>
