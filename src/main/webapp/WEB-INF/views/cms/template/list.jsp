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
    <title>模板列表</title>
    <link href="${ctx}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/static/css/july.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 list-body">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">模板列表</h3>
                </div>
                <div class="panel-body">
                    <div class="row search-content">
                    	<div class="col-xs-8">
	                        <form id="queryForm" class="form-inline" action="${ctx }/template/list">
	                        	<input id="catalogId" type="hidden" name="catalogId" value="${catalogId}"/>
	                        	<input id="totalSize" type="hidden" name="totalSize" value="${pageInfo.totalPage}"/>
			  					<input id="pageSize" type="hidden" name="pageSize" value="${pageInfo.pageSize }"/>
			  					<input id="currentPage" type="hidden" name="currentPage" value="${pageInfo.currentPage}"/>
	                            <div class="form-group">
	                                <div class="input-group">
	                                    <div class="input-group-addon">模板名称</div>
	                                    <input class="form-control" type="text" id="name" name="name" value="${template.name }">
	                                </div>
	                            </div>
	                            <button type="submit" class="btn btn-default">查询</button>
	                        </form>
                        </div>
                        <div class="col-xs-4">
                        	<a href="${ctx}/template/edit?catalogId=${catalogId}" class="btn btn-success">新增</a>
							<a id="batchDel" class="btn btn-danger">删除</a>
                        </div>
                    </div>
                    <table class="table table-hover table-bordered">
                        <thead>
	                        <tr>
	                            <th><input id="chkAll" type="checkbox"/></th>
					          	<th>名称</th>
					          	<th>类型</th>
					          	<th>发布路径</th>
					          	<th>状态</th>
					          	<th>修改人</th>
					          	<th>修改时间</th>
					          	<th>操作</th>
	                        </tr>
                        </thead>
                        <tbody>
				        	<c:forEach items="${pageInfo.content }" var="template">
				        		<tr>
				        			<td><input name="chkName" type="checkbox" value="${template.id }" /></td>
				        			<td>${template.name }</td>
				        			<td>${template.type}</td>
				        			<td>${template.path }</td>
				        			<td>${template.status }</td>
				        			<td>${template.updateBy }</td>
				        			<td>${template.updateTime }</td>
				        			<td>
				        				<a href="${ctx }/template/edit?id=${template.id}&catalogId=${catalogId}">编辑</a>
				        			</td>
				        		</tr>
				        	</c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="8">每页显示
                                    <select id="showSize" name="showSize">
                                        <option value="10" selected="selected">10</option>
                                        <option value="20">20</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                        <option value="200">200</option>
                                    </select>条,总计${pageInfo.totalElements}条,当前${pageInfo.currentPage + 1}/${pageInfo.totalPage}页
                                    <nav class="page-footer">
                                    	<ul class="pagination" id="pageDiv"></ul>
                                    </nav>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${ctx}/static/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/page_sync.js"></script>
<script type="text/javascript">
$(function () {
	//分页
	var currentPage = $('#currentPage').val(),
	totalSize = $('#totalSize').val(),
	pageSize = $('#pageSize').val();
	PageSync.init(currentPage,pageSize,totalSize);
	
	//全选
	$('#chkAll').on('click',function(){
		$('input[name="chkName"]').prop('checked',$(this).prop('checked'));
	});
	
	//删除
	$('#batchDel').on('click',function(){
   		var checked = checkedCheckBox();
   		if(checked.length > 0){
   			if(confirm("确定删除吗？")){
 				 $.ajax({
   					url   : "${ctx}/template/batchDel",
   					type  : "POST",
   					async : false,
   					data  :{"ids":checked.join(",")},
   					dataType : "json",
   					success  : function(data){
   						if(data.isSuccess){
   							removeTr(checked);
   						}else{
   							alert(data.msg);
   						}
   					}
   				}); 
   			}
   		}
   	});
});

//获取选中的checkbox值
function checkedCheckBox(){
	var checked = [];
	$("input[name='chkName']:checked").each(function(){
		checked.push($(this).val());
	});
	if(checked.length<=0){
		alert("请选择");
	}
	return checked;
}

function removeTr(tds){
	for(var i = 0;i<tds.length;i++){
		$('#data'+tds[i]).remove();
	}
}
</script>
</body>
</html>