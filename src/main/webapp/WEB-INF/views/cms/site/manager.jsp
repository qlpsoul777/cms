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
		<!-- <div class="container-fluid">
	  		<iframe id="mainIframe" name="mainIframe" width="100%" height="100%" border="0" frameborder="no" style="border: none;
             padding: 0px; margin: 0px;min-height: 530px;overflow-y: scroll;"></iframe>	
  		</div> -->
		<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
		<script src="${ctx}/static/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(function () {
			var menu = $('#headermenu',parent.document);
			var html = '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">站点管理<span class="caret"></span></a><ul class="dropdown-menu" role="menu"><li><a href="${ctx}/catalog/manager" target="content_iframe">栏目管理</a></li><li><a href="#">模板管理</a></li><li><a href="#">变量管理</a></li><li class="divider"></li><li><a href="#">发布管理</a></li><li><a href="#"></a></li></ul></li>';
			menu.html(html);
			
			$('#content_iframe',parent.document).attr('src','${ctx}/catalog/manager');
		});
	
		function init(target){
			var y = window.screen.availHeight - 200;
			var x =  window.screen.availWidth  - 200;
			if(y <= 200){y = 200;}
			if(x <= 200){x = 200;}
			$('#mainIframe').css({"height":y+"px", "width":x+"px"});
			$('#mainIframe').attr('src',target.eq(0).attr('href'));
		}
		</script>
	</body>
</html>