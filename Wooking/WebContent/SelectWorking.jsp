<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的工作笔记</title>
<style>
	table{
		text-align: center;
		margin: 0px auto;
	}
</style>
</head>
<body>
	
	<table>
		<tr>
		<th colspan="2"><h1>我的工作笔记</h1></th>
		</tr>
		<tr>
			<td>标签</td><td><span id='title'></span></td>
		</tr>
		<tr>
			<td>内容</td><td><span id='content'></span></td>
		</tr>
		<tr>
			<td>类别</td><td><span id='type'></span></td>
		</tr>
		<tr>
			<td>日期</td><td><span id='createDate'></span></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="返回"/></td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			"url":"SelectWorkingById",
			"type":"post",
			"dataType":"json",
			"data":{
				"id":get("id")
			},
			"success":function(data){
				alert()
				$("#title").text(data.title);
				$("#content").text(data.content);
				switch (data.type) {
				case 1:
					$("#type").text("技术");
					break;
				case 2:
					$("#type").text("行政");
					break;
				case 3:
					$("#type").text("人事");
					break;
				}
				$("#createDate").text(getLocalTime(data.createDate));
			}
		});
		function get(par){
			    //获取当前URL
			    var local_url = document.location.href;
			     
			    //截取baiget字符串
			    var getstr = local_url.substr(local_url.indexOf('?')+1);
			     
			    //解析du成get数组
			    var get = getstr.split('&');
			     
			    //查找要找到参数（par）
			    for(var i in get){
			        if(get[i].indexOf(par+'=')>=0){
			            return get[i].replace(par+'=','');
			        }
			    }
			     
			    //如果zhi找不到返回daofalse
			    return false;
			}
		function getLocalTime(jsondate) {
            jsondate=""+jsondate+"";//因为jsonDate是number型的indexOf会报错
            if (jsondate.indexOf("+") > 0) {
                jsondate = jsondate.substring(0, jsondate.indexOf("+"));
            }
            else if (jsondate.indexOf("-") > 0) {
                jsondate = jsondate.substring(0, jsondate.indexOf("-"));
            }
            var date = new Date(parseInt(jsondate, 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            // var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            // var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            // var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            return date.getFullYear() + "-" + month + "-" + currentDate;
                // " " " + hours + ":" + minutes + ":" + seconds;
        }
		$("input[type='button']").click(function(){
			location.href="index.jsp";
		});
	});
</script>
</html>