<%--
  Desc: index.jsp
  User: <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
  Date: 2019-08-07 18:28
  Version: 1.0.0
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>更新信息</title>
    <style>
        #login_click{ margin-top:32px; height:40px;}
        #login_click a
        {


            text-decoration:none;
            background:#2f435e;
            color:#f2f2f2;

            padding: 10px 30px 10px 30px;
            font-size:16px;
            font-family: 微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;
            font-weight:bold;
            border-radius:3px;

            -webkit-transition:all linear 0.30s;
            -moz-transition:all linear 0.30s;
            transition:all linear 0.30s;

        }
        #login_click a:hover { background:#385f9e; }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/health/update" runat="server">
    <input type="hidden" id="id" name="id" value="${requestScope.entity.id}">
    <input type="hidden" id="deptName" name="deptName" value="${requestScope.entity.deptName}">
    <table align="center" border="0px;" cellspacing="0" cellpadding="10">
        <tr><td colspan="2"><label>${requestScope.message} </label><br></td></tr>
        <tr><td>乡 镇:</td><td>
        <select id="deptCode" name="deptCode" onchange="deptCodeChange(this);">
            <option value='玉潭'/>玉潭</option>
            <option value='道林'/>道林</option>
            <option value='老粮仓'/>老粮仓</option>
            <option value='青山桥'/>青山桥</option>
            <option value='黄材'/>黄材</option>
            <option value='流沙河'/>流沙河</option>
            <option value='巷子口'/>巷子口</option>
            <option value='历经铺'/>历经铺</option>
            <option value='城郊'/>城郊</option>
            <option value='花明楼'/>花明楼</option>
            <option value='回龙铺'/>回龙铺</option>
            <option value='沙田'/>沙田</option>
            <option value='龙田'/>龙田</option>
            <option value='东湖塘'/>东湖塘</option>
            <option value='双凫铺'/>双凫铺</option>
            <option value='坝塘'/>坝塘</option>
            <option value='夏铎铺'/>夏铎铺</option>
            <option value='白马桥'/>白马桥</option>
            <option value='灰汤镇'/>灰汤镇</option>
            <option value='大屯营'/>大屯营</option>
            <option value='喻家坳'/>喻家坳</option>
            <option value='大城桥'/>大城桥</option>
            <option value='金洲'/>金洲</option>
            <option value='煤炭坝'/>煤炭坝</option>
            <option value='沩山'/>沩山</option>
            <option value='菁华铺'/>菁华铺</option>
            <option value='横市'/>横市</option>
            <option value='资福'/>资福</option>
            <option value='双江口'/>双江口</option>

        </select>
        </td></tr>
        <tr><td>行政村/社区: </td><td><input name="name" value="${requestScope.entity.name}"></td></tr>
        <tr><td>姓 名: </td><td><input name="name" value="${requestScope.entity.name}"></td></tr>
        <tr><td>手 机: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>身份证号码: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>目前在湖南居住地（现住址/酒店名称、地址）: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>体温（℃）: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>有无咳嗽、胸闷等不适症状: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>湖北居住地（现住址/酒店名称、地址）*: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>离开湖北所在地级市: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>离开湖北日期: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>车次/航班/汽车/自驾*: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>沿途是否停留？如是，停留地点: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>
        <tr><td>同行人员姓名: </td><td><input name="phone" value="${requestScope.entity.phone}"></td></tr>

    <tr align="center"><td colspan="2"><input type="submit" value="提  交">
        <a id="btlogin" href="#">登 录</a></td></tr>
    </table>
</form>
<script>
    // 科室
    var deptCodeVal = '${requestScope.entity.deptCode}';
    var deptCodeLen = document.getElementById("deptCode").options.length;
    for (var i = 0; i < deptCodeLen; i ++) {
        if (deptCodeVal === document.getElementById("deptCode").options[i].value) {
            document.getElementById("deptCode").options[i].selected = true;
        }
    }
    // 职称
    var title = '${requestScope.entity.title}';
    var titleLen = document.getElementById("title").options.length;
    for (var i = 0; i < titleLen; i ++) {
        if (title === document.getElementById("title").options[i].value) {
            document.getElementById("title").options[i].selected = true;
        }
    }

    function deptCodeChange(obj) {
        var selectIndex = obj.selectedIndex;
        var selectValue = obj.options[selectIndex].innerText;
        console.log(selectValue);
        document.getElementById("deptName").value = selectValue;
    }
</script>
</body>
</html>
