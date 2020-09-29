

$(function(){
		
		//-->右键自定义菜单
	   var drawing =document.getElementsByClassName("drawing")[0];
	   var menu = document.getElementById('menu');
	   //当前操作的歌单
	    var list_create = null;
		/*刷新右键选择的样式*/
		function refreshMenu(){
			drawing =document.getElementsByClassName("drawing")[0];
			menu = document.getElementById('menu');
			LTEvent.addListener(drawing,"contextmenu",LTEvent.cancelBubble);
			LTEvent.addListener(drawing,"contextmenu",showmenu);
			LTEvent.addListener(document,"click",hidemenu);  
		}
		
		$("#songListList").on("click",".list_create_001",function(){
			refreshMenu();
			list_create=$(this);
		})
	   /*显示菜单*/
	   function showmenu() {
					
			
	       var evt = window.event || arguments[0];
	        
	       /*获取当前鼠标右键按下后的位置，据此定义菜单显示的位置*/
	       var rightedge = drawing.clientWidth-evt.clientX;
	       var bottomedge = drawing.clientHeight-evt.clientY;
	       /*如果从鼠标位置到容器右边的空间小于菜单的宽度，就定位菜单的左坐标（Left）为当前鼠标位置向左一个菜单宽度*/
	       if (rightedge < menu.offsetWidth)               
	           menu.style.left = drawing.scrollLeft + evt.clientX - menu.offsetWidth + "px";            
	       else
	       /*否则，就定位菜单的左坐标为当前鼠标位置*/
	           menu.style.left = drawing.scrollLeft + evt.clientX + "px";
	        
	       /*如果从鼠标位置到容器下边的空间小于菜单的高度，就定位菜单的上坐标（Top）为当前鼠标位置向上一个菜单高度*/
	       if (bottomedge < menu.offsetHeight)
	           menu.style.top = drawing.scrollTop + evt.clientY - menu.offsetHeight + "px";
	       else
	       /*否则，就定位菜单的上坐标为当前鼠标位置*/
	       menu.style.top = drawing.scrollTop + evt.clientY + "px";
						
	       menu.style.visibility = "visible";             
	       LTEvent.addListener(menu,"contextmenu",LTEvent.cancelBubble);
	   }
	   /*隐藏菜单*/
	   function hidemenu() {
	       menu.style.visibility = 'hidden';
	   }
	   LTEvent.addListener(drawing,"contextmenu",LTEvent.cancelBubble);
	   LTEvent.addListener(drawing,"contextmenu",showmenu);
	   LTEvent.addListener(document,"click",hidemenu);  
	
	
	/*增加歌单的方法传入的参数分别是：当前时间，当前用户编号，歌单名*/
	function addSongList(userId,songListName){
		if(userId == -1){
			showTipBox("info", "您尚未登录，请先登录再进行操作！");
			return ;
		}
		$.ajax({
			"url":"AddSongList",
			"dataType":"text",
			"type":"post",
			"data":{
				"mCreateName":userId,
				"mName":songListName
			},
			"success":function(data){
				if(data>0){
					$("#songListList").append("<p class='btn list_create_001'><i class='fa fa-music' aria-hidden='true'></i>&nbsp;&nbsp;"+songListName+"</p>");
				}else{
					showTipBox("info", "歌单新增失败！");
				}
			}
		});
	}


	$("#addimg").click(function(){
		$(".addList").toggle();
	});
	$("#addSongListCancel").click(function(){
		$(".addList").hide();
	});
	$("#addSongListbtn").click(function(){
		var songListName = $("#songListValue #usr").val().trim();
		if(songListName == ""){
			showTipBox("info", "歌单名不能为空！请输入歌单名");
			return;
		}
		$(".addList").hide();
		$("#songListValue #usr").val("");
		//先传入一个1作为测试
		addSongList(1,songListName);
	});
	
	$(".list_create_001").hover(function(){
		$(this).find(".fa-trash").show();
	},function(){
		$(this).find(".fa-trash").hide();
	})
	
	
		                 
		
	
	
	
	   
});

