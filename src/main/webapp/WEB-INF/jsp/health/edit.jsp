<%--
  Desc: index.jsp
  User: <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
  Date: 2019-08-07 18:28
  Version: 1.0.0
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin user Examples</title>
    <meta name="description" content="这是一个 user 页面">
    <meta name="keywords" content="user">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/css/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="${pageContext.request.contextPath}/css/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <strong>上报信息</strong>
    </div>
</header>

<div class="am-cf admin-main">

    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <hr/>
            <div class="am-u-sm-12 am-u-md-12 am-u-md-pull-12">
                <form class="am-form am-form-horizontal" method="post" action="${pageContext.request.contextPath}/health/add">
                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label">行政村/社区</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-name" placeholder="行政村/社区">
                            <small>输入返宁人员目前所在行政村或社区</small>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="user-name" class="am-u-sm-3 am-form-label">姓名</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-name" placeholder="姓名 / Name">
                            <small>输入返宁人员姓名</small>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-phone" class="am-u-sm-3 am-form-label">手机号码</label>
                        <div class="am-u-sm-9">
                            <input type="tel" id="user-phone" placeholder="联系方式（手机号）">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-idcard" class="am-u-sm-3 am-form-label">身份证号</label>
                        <div class="am-u-sm-9">
                            <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="身份证号">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-QQ" class="am-u-sm-3 am-form-label">目前在湖南居住地</label>
                        <div class="am-u-sm-9">
                            <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="目前在湖南居住地（现住址/酒店名称、地址）">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-weibo" class="am-u-sm-3 am-form-label">微博</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-temp" class="am-u-sm-3 am-form-label">体温（℃）</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-temp" placeholder="体温（℃）">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">不适症状</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-intro" placeholder="有无咳嗽、胸闷等不适症状">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">湖北居住地</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-intro" placeholder="湖北居住地（现住址/酒店名称、地址）*">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">离开湖北所在地级市</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-intro" placeholder="离开湖北所在地级市">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">离开湖北日期</label>
                        <div class="am-u-sm-9">
<%--                            <input type="text" id="user-intro" placeholder="离开湖北日期">--%>
                            <div class="am-form-group am-form-icon">
                                <i class="am-icon-calendar"></i>
                                <input type="date" class="am-form-field am-input-sm" placeholder="离开湖北日期">
                            </div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">车次/航班/汽车/自驾*</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-intro" placeholder="车次/航班/汽车/自驾*">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">沿途是否停留？如是，停留地点</label>
                        <div class="am-u-sm-9">
                            <input type="text" id="user-intro" placeholder="沿途是否停留？如是，停留地点">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="user-intro" class="am-u-sm-3 am-form-label">同行人员姓名</label>
                        <div class="am-u-sm-9">
                            <textarea id="user-intro" placeholder="同行人员姓名"></textarea>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
<%--                            <button type="submit" class="am-btn am-btn-primary">保存修改</button>--%>
                            <input type="submit" name="" value="提交信息" class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <footer class="admin-content-footer">
        <hr>
        <p class="am-padding-left">© 2020 FITT, Inc. Licensed under MIT license.</p>
    </footer>

</div>
<!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
   data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
    <hr>
    <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/css/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/css/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/css/assets/js/amazeui.min.js"></script>

<script src="${pageContext.request.contextPath}/css/assets/js/app.js"></script>
</body>
</html>

