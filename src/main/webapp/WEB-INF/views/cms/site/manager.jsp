<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
    	<title>站点管理</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
	    <link href="${ctx}/static/js/ztree3/zTreeStyle/zTreeStyle.css" rel="stylesheet">
  	</head>
	<body>
		<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
		<script src="${ctx}/static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(function () {
			var menu = $('#headermenu',parent.document);
			var html = '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">站点管理<span class="caret"></span></a><ul class="dropdown-menu" role="menu"><li><a href="${ctx}/catalog/manager" target="content_iframe">栏目管理</a></li><li><a href="${ctx}/catalog/visibleTree/1" target="content_iframe">模板管理</a></li><li><a href="${ctx}/catalog/visibleTree/2" target="content_iframe">内容管理</a></li><li class="divider"></li><li><a href="#">发布管理</a></li><li><a href="#"></a></li></ul></li>';
			menu.html(html);
			
			$('#content_iframe',parent.document).attr('src','${ctx}/catalog/manager');
		});
		</script>
	</body>
</html>