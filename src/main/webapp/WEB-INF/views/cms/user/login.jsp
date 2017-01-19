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
    <title>登录</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
   <div class="row">
		<form id="editForm" class="form-horizontal" action="${ctx}/user/login" method="post">
		  	<div class="form-group">
			    <label for="name" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-10">
					<input type="text" class="form-control" id="loginName" name="loginName"/>
			    </div>
		  	</div>
			<div class="form-group">
				<label for="num" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label for="num" class="col-sm-2 control-label">验证码</label>
				<div class="col-sm-10">
					<input type="hidden" name="token">
					<input type="text" class="form-control" id="captchaCode" name="captchaCode"/>
					<img id="codeImg" src="${ctx }/captcha.jpg"/>
					<span>看不清，<a id="changeImg">换一张</a></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">登录</button>
				</div>
			</div>
		</form>
	</div>
</div>

<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#changeImg').on('click',function(){
			$("#codeImg").attr("src",'${ctx }/captcha.jpg?'+new Date().getTime());
		});
	});
</script>
</body>
</html>