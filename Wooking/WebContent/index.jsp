<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>工作笔记</title>

<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<style type="text/css">
	table{
	margin: 0px auto;
	text-align: center;
	}
	h1{
		text-align: center;
	}
	div{
		text-align: center;
	}
	table tr:nth-child(even){/*设置表格偶数行隔行变色*/
	background-color: cadetblue; 
	}
  	table tr:first-child {
	background-color: rgb(252,124,25);
	}
</style>
</head>

<body>
	<div>
	<h1>工作笔记</h1>
	<table border="1">
	<a href="addWorking.jsp">添加笔记</a>
		<tr>
			<th>笔记标题</th>
			<th>笔记分类</th>
			<th>笔记编写时间</th>
			<th>操作</th>
		</tr>
	</table>
		<button id="left" style="font-size:12px"><i class="fa fa-angle-double-left" style="font-size:12px;color:black;"></i>上一页</button>
		<button id="right" style="font-size:12px">下一页<i class="fa fa-angle-double-right" style="font-size:12px;color:black;"></i></i></button>
	</div>
	
</body>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		var index=0;
		$.ajax({
			"url":"getWorking",
			"dataType":"json",
			"data":"index="+index,
			"type":"post",
			"success":function(wookings){
				
				$(wookings).each(function(){
					var $tr = $("<tr></tr>");
					$tr.append("<td>"+this.title+"</td>");
					switch (this.type) {
					case 1:
						$tr.append("<td>技术</td>");
						break;
					case 2:
						$tr.append("<td>行政</td>");
						break;
					case 3:
						$tr.append("<td>人事</td>");
						break;
					}
					$tr.append("<td>"+getLocalTime(this.createDate)+"</td>"
							+'<td><a href=SelectWorking.jsp?id='+this.id+">查看</a></td>");
					$("table").append($tr);
				});
			}
		});
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
		//上一页
		$("#left").click(function(){
			if(index<=0){
				index=0;
				alert("已经是最顶层了！");
				return;
			}
			index--;
			$.ajax({
				"url":"getWorking",
				"data":"index="+index,
				"dataType":"json",
				"type":"post",
				"success":function(wookings){
					$("table").html("<tr>"
							+"<th>笔记标题</th>"
							+"<th>笔记分类</th>"
							+"<th>笔记编写时间</th>"
							+"<th>操作</th>"
						+"</tr>");
					$(wookings).each(function(){
						var $tr = $("<tr></tr>");
						$tr.append("<td>"+this.title+"</td>");
						switch (this.type) {
						case 1:
							$tr.append("<td>技术</td>");
							break;
						case 2:
							$tr.append("<td>行政</td>");
							break;
						case 3:
							$tr.append("<td>人事</td>");
							break;
						}
						$tr.append("<td>"+getLocalTime(this.createDate)+"</td>"
								+'<td><a href=SelectWorking.jsp?id='+this.id+">查看</a></td>");
						$("table").append($tr);
					});
				}
			});
		});
		//下一页
		$("#right").click(function(){
			index++;
			$.ajax({
				"url":"getWorking",
				"data":"index="+index,
				"dataType":"json",
				"type":"post",
				"success":function(wookings){
					if(null ==wookings || ""==wookings){
						index--;
						alert("已经是最后一页了！！！");
						return;
					}
					$("table").html("<tr>"
							+"<th>笔记标题</th>"
							+"<th>笔记分类</th>"
							+"<th>笔记编写时间</th>"
							+"<th>操作</th>"
						+"</tr>");
					$(wookings).each(function(){
						var $tr = $("<tr></tr>");
						$tr.append("<td>"+this.title+"</td>");
						switch (this.type) {
						case 1:
							$tr.append("<td>技术</td>");
							break;
						case 2:
							$tr.append("<td>行政</td>");
							break;
						case 3:
							$tr.append("<td>人事</td>");
							break;
						}
						$tr.append("<td>"+getLocalTime(this.createDate)+"</td>"
								+'<td><a href=SelectWorking.jsp?id='+this.id+">查看</a></td>");
						$("table").append($tr);
					});
				}
			});
		});
	});
</script>
</html>