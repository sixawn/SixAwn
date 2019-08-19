<%--
  Desc: index.jsp
  User: <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
  Date: 2019-08-07 18:28
  Version: 1.0.0
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>更新信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select.css">
    <script src="http://apps.bdimg.com/libs/jquery/1.8.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/select.js"></script>
</head>
<body>
<form name="userForm" id="userForm" method="post" action="${pageContext.request.contextPath}/user/update"
      onsubmit="submitFun();">
    <input type="hidden" id="id" name="id" value="${requestScope.entity.id}">
    <input type="hidden" id="deptCode" name="deptCode" value="${requestScope.entity.deptCode}">
    <input type="hidden" id="deptName" name="deptName" value="${requestScope.entity.deptName}">
    <table align="center" border="0px;" cellspacing="0" cellpadding="10">
        <tr>
            <td colspan="2"><label>${requestScope.message} </label><br></td>
        </tr>
        <tr>
            <td>姓 名:</td>
            <td>
                <label>
                    <input name="name" value="${requestScope.entity.name}">
                </label>
            </td>
        </tr>
        <tr>
            <td>工 号:</td>
            <td>
                <label>
                    <input name="code" value="${requestScope.entity.code}">
                </label>
            </td>
        </tr>
        <tr>
            <td>手机号码:</td>
            <td><label>
                <input name="phone" value="${requestScope.entity.phone}">
            </label></td>
        </tr>
        <tr>
            <td>开通权限:</td>
            <td>
                <label><input type="checkbox" name="permission" value="1"/>会诊</label>
                <label><input type="checkbox" name="permission" value="2" checked/>转运</label>
            </td>
        </tr>
        <tr>
            <td>职 称:</td>
            <td>
                <label>
                    <select id="title" name="title">
                        <option value="1">主任医师</option>
                        <option value="2">副主任医师</option>
                        <option value="3">主治医师</option>
                        <option value="4">住院医师</option>
                        <option value="5">主任护师</option>
                        <option value="6">副主任护师</option>
                        <option value="7">主管护师</option>
                        <option value="8">护师</option>
                        <option value="9">护士</option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td>所选科室:</td>
            <td>
                <div id="selectDeptName">${requestScope.entity.deptName}</div>
            </td>
        </tr>
        <tr>
            <td>选择科室:</td>
            <td>
                <ul class="ul_select" id="deptCodes">
                    <c:forEach items="${requestScope.deptList}" var="dept">
                        <li value="${dept.deptCode}">${dept.deptName}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提  交"></td>
        </tr>
    </table>
</form>
<script>
    // 科室
    var deptCodeVal = '${requestScope.entity.deptCode}';
    var deptCodeValArr = deptCodeVal.split(",");

    var liArr = document.getElementsByTagName("li");
    for (var i = 0; i < liArr.length; i++) {
        for (j = 0; j < deptCodeValArr.length; j++) {
            if (deptCodeValArr[j] == liArr[i].value) {
                liArr[i].className = "choosed";
            }
        }
    }

    // 职称
    var title = '${requestScope.entity.title}';
    var titleLen = document.getElementById("title").options.length;
    for (var i = 0; i < titleLen; i++) {
        if (title == document.getElementById("title").options[i].value) {
            document.getElementById("title").options[i].selected = true;
        }
    }

    // 开通权限
    var permissionVal = '${requestScope.entity.permission}';
    var permissionValArr = permissionVal.split(",");
    var permission = document.getElementsByName("permission");
    for (var i = 0; i < permission.length; i++) {
        for (var j = 0; j < permissionValArr.length; j++) {
            if (permissionValArr[j] == permission[i].value) {
                permission[i].checked = true;
            }
        }
    }


    var deptCode = "";
    var deptName = "";

    function submitFun() {
        var deptLiArr = document.getElementsByTagName("li");

        for (var i = 0; i < deptLiArr.length; i++) {
            if (deptLiArr[i].className === 'choosed') {
                deptCode += deptLiArr[i].value + ",";
                deptName += deptLiArr[i].textContent + ",";
            }
        }

        document.getElementById("deptCode").value = deptCode;
        document.getElementById("deptName").value = deptName;

        document.getElementById("form").submit();
    }
</script>
</body>
</html>