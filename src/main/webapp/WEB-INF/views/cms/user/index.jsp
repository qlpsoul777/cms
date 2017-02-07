<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/july.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="topHeader">
            <div class="top-left">
               	<div class="logo-img">
	               <a href="index.html">
                       <img src="${ctx}/static/images/july.ico"/>
	               </a>
                </div>
                <span class="slogan">CMS后台管理系统</span>
                <div class="search">
                    <form class="form-inline form-search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="搜索">
                          <span class="input-group-btn">
                            <button class="btn btn-default" type="submit">
                                <i class="icon-search"></i>
                            </button>
                          </span>
                        </div>
                    </form>
                </div>
                <br clear="all" />
            </div>
            <div class="top-right">
                <div class="user-block">
                    <a href="#" id="userToggle" data-toggle="dropdown">
                        <img src="${ctx}/static/images/headPhoto.jpg" alt="" class="img-photo">
                        <div class="user-detail inline-block">
                            admin
                            <span class="icon-caret-down"></span>
                        </div>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="icon-edit"></i>修改密码</a></li>
                        <li><a href="#"><i class="icon-upload"></i>上传头像</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="icon-off"></i>锁屏</a></li>
                        <li><a href="#"><i class=" icon-signout"></i>注销</a></li>
                    </ul>
                </div>
                <ul class="nav-notification">
                    <li>
                        <a href="/email.html" data-toggle="dropdown">
                            <i class="icon-envelope icon-large"></i>
                        </a>
                        <span class="badge badge-purple bounceIn animation-delay5 active">2</span>
                    </li>
                    <li>
                        <a href="/letter.html" data-toggle="dropdown">
                            <i class="icon-bell icon-large"></i>
                        </a>
                        <span class="badge badge-purple bounceIn animation-delay5 active">4</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="navcontent">
            <ul class="headermenu">
                <li class="active"><a href="index.html">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">站点管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="list.html" target="content_iframe">栏目管理</a></li>
                        <li><a href="#">模板管理</a></li>
                        <li><a href="#">变量管理</a></li>
                        <li class="divider"></li>
                        <li><a href="#">发布管理</a></li>
                        <li><a href="#"></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">新闻管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">新闻管理</a></li>
                        <li><a href="#">抓取管理</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">广告管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">广告组管理</a></li>
                        <li><a href="#">广告管理</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">活动管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">活动管理</a></li>
                        <li><a href="#">活动附件管理</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">用户管理</a></li>
                        <li><a href="#">角色管理</a></li>
                        <li><a href="#">日志管理</a></li>
                        <li class="divider"></li>
                        <li><a href="#">系统参数管理</a></li>
                        <li><a href="#">日志管理</a></li>
                    </ul>
                </li>
            </ul>


        </div>
    </div>

    <div class="row">
            <iframe id="content_iframe" name="content_iframe"  width="100%" height="100%" border="0" frameborder="no" style="border: none;
             padding: 0px; margin: 0px;min-height: 530px;overflow-y: scroll;"
                    src="${ctx}/site/list"></iframe>
    </div>

    <div class="row">
        <div class="footer">
            <p>鸿起星河版权所有@备案/许可证编号：鄂ICP备1107777777号</p>
        </div>
    </div>
</div>

<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $('.headermenu > li').on('click',function(){
        $(this).addClass('active').siblings().removeClass('active');
    });
</script>
</body>
</html>