<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加笔记信息</title>
<style type="text/css">
	form{
		text-align: center;
	}
	table{
		text-align: center;
		margin: 0px auto;
	}
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>我的工作笔记</h1>
	<form action="" method="post">
		<table>
			<tr>
			<td>标题</td><td><input type="text" name="title"/></td>
			</tr>
			<tr>
			<td>内容</td><td><textarea name="content"></textarea></td>
			</tr>
			<tr>
			<td>类别</td>
			<td>
				<select name="type">
					<option value="0">请选择类别</option>
					<option value="1">技术</option>
					<option value="2">行政</option>
					<option value="3">人事</option>
				</select>
			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"/></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("form").submit(function(){
			if($("input[name='title']").val()==''){ 
				alert("标题不能为空！");
				return false;
			}
			if($("textarea").val()==''){
				alert("内容不能为空！");
				return false;
			}
			if($("select").val()=='0'){
				alert("请选择类别！");
				return false;
			}
			var $formAreas = $("input,select,textarea");
			//将表单编码成为数组格式
			var paramsArray = $formAreas.serializeArray();
			//将数据序列化成请求字符串
			var queryString = $.param(paramsArray);
			//使用post提交方式简写
			$.ajax({
				"url":"AddWorking",
				"data":queryString,
				"dataType":"text",
				"success":function(data){
					if(data>0){
						alert("新增成功！");
						location.href="index.jsp";
					}else{
						alert("新增失败！");
					}
				}
			});
			return false;
		});
		
	});
</script>
</html>