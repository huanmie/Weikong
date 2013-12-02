<%@ page language="java" contentType="text/html; charset=UTF-8" deferredSyntaxAllowedAsLiteral="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String action = request.getParameter("action");
	System.out.println("$$$$$$$$$"+action+"$$$$$$$$$$$$$$$$");
	if("login".equals(action)){
		session.setAttribute("userName",request.getParameter("userName")==null?"123123":request.getParameter("userName"));
		//rs.createDeployment().addResourceFromClasspath("qingjia.jpdl.xml").deploy();
	}
%>
<html>
	<head>
		
		<title>test</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />
		<!-- layout 用的样式和js -->
		<link type="text/css" rel="stylesheet" href="layout/layout/layout-default-latest.css" />
		<link type="text/css" rel="stylesheet" href="css/main.css" />
		<script type="text/javascript" src="layout/layout/jquery-latest.js"></script>
		<script type="text/javascript" src="layout/layout/jquery-ui-latest.js"></script>
		<script type="text/javascript" src="layout/layout/jquery.layout-latest.js"></script>
		<script type="text/javascript" src="layout/layout/debug.js"></script>
		<script type="text/javascript" src="layout/layout/jquery.corner.js"></script>

		
		
		<!-- start tabs的样式和js -->
		<link rel="stylesheet" href="layout/development-bundle/themes/cupertino/jquery.ui.all.css">
		<!--<script src="layout/development-bundle/jquery-1.7.2.js"></script>-->
		<script src="layout/development-bundle/ui/jquery.ui.position.js"></script>
		<script src="layout/development-bundle/ui/jquery.ui.core.js"></script>
		<script src="layout/development-bundle/ui/jquery.ui.widget.js"></script>
		<script src="layout/development-bundle/ui/jquery.ui.button.js"></script>
		<script src="layout/development-bundle/ui/jquery.ui.tabs.js"></script>
		<script src="layout/development-bundle/ui/jquery.ui.dialog.js"></script> 
		
		
		<style>
		#dialog label, #dialog input { display:block; }
		#dialog label { margin-top: 0.5 em; }
		#dialog input, #dialog textarea { width: 95%; }
		#tabs { margin-top: 0em; }
		
		#add_tab { cursor: pointer; }
		#tabs {padding:1px;}
		#tabs ul{margin:0px;padding:0px;padding-bottom:1px;}
		#tabs li{height:25px;line-height:25px;font-size:12px;margin:0px 0px 0px 2px;padding:0px 2px 0px 2px;}
		#tabs li a { height:25px;line-height:25px;font-size:12px;margin-left:2px;padding:0px 5px 0px 5px;}
		#tabs li .ui-icon-close { float: left; margin: 0.4em 0.2em 0 0; cursor: pointer; }
		</style>
		<script>

		$(function() {
			var $tab_title_input = $( "#tab_title"),
				$tab_content_input = $( "#tab_content" );
			var tab_counter = 2;
	
			// tabs init with a custom tab template and an "add" callback filling in the content
			var $tabs = $( "#tabs").tabs({
				tabTemplate: "<li> <a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>",
				panelTemplate: "<div style='padding:0px;height:480px;'></div>",
				add: function( event, ui ) {
					//$( ui.panel ).css({height:450px});
					var aid = ui.tab.hash.substring(ui.tab.hash.indexOf("#tabs-")+6);
					//alert(aid);
					//alert($("#"+aid).attr("task"));
					var pageurl = $("#"+aid).attr("task");
					//alert('<iframe id="contentFrame" frameBorder="0" style="height:100%;width:100%;margin:0px;padding:0px;" src="<%=path%>/'+pageurl+'"></iframe>');
					$( ui.panel ).append('<iframe id="contentFrame" frameBorder="0" style="height:100%;width:100%;margin:0px;padding:0px;overflow:hidden;" src="<%=path%>/'+pageurl+'"></iframe>');
				}
			});
	
			// modal dialog init: custom buttons and a "close" callback reseting the form inside
			var $dialog = $( "#dialog" ).dialog({
				autoOpen: false,
				modal: true,
				buttons: {
					Add: function() {
						addTab();
						$( this ).dialog( "close" );
					},
					Cancel: function() {
						$( this ).dialog( "close" );
					}
				},
				open: function() {
					$tab_title_input.focus();
				},
				close: function() {
					$form[ 0 ].reset();
				}
			});
	
			// addTab form: calls addTab function on submit and closes the dialog
			var $form = $( "form", $dialog ).submit(function() {
				addTab();
				$dialog.dialog( "close" );
				return false;
			});
	
			// actual addTab function: adds new tab using the title input from the form above
			function addTab() {
				//var tab_title = $tab_title_input.val() || "Tab " + tab_counter;
				var tabId = "#tabs-" + tab_counter;
				$tabs.tabs( "add", tabId , "新增Tab" );
				tab_counter++;
			}
	
			// addTab button: just opens the dialog
			$( "#add_tab" )
				.button()
				.click(function() {
					$dialog.dialog( "open" );
				});
	
			// close icon: removing the tab on click
			// note: closable tabs gonna be an option in the future - see http://dev.jqueryui.com/ticket/3924
			$( "#tabs span.ui-icon-close" ).live( "click", function() {
				var index1 = $( "li", $tabs ).index( $( this ).parent() );
				$tabs.tabs( "remove", index1 );
				index--;
			});
		});
		
		// 自定义add方法，其他都无效
		var index=2;
		function addTab(obj) {
				//var tab_title = $tab_title_input.val() || "Tab " + tab_counter;
				// 先判断tab页是否存在，如果存在，直接显示，否则新增
				if($("#tabs-" + $(obj).attr("id")).size()>0){
					$("#tabs").tabs( 'select' , "#tabs-" + $(obj).attr("id") ) ;
				}else{
					// 不允许超过8个tab页
					if(index>8){
						alert("最多只能打开8个tab页，请先关闭不使用的页面");
						return;
					}
					$("#tabs").tabs( "add", "#tabs-" + $(obj).attr("id"), $(obj).html() );
					$("#tabs").tabs( 'select' , "#tabs-" + $(obj).attr("id") ) ;
					index++;
				}
			}
		
		</script>
		<!--  end tabs的样式和js -->
		
		<script type="text/javascript">
	
		function toggleLiveResizing () {
			$.each('north,south,west,east'.split(','), function (i, pane) {
				var opts = myLayout.options[ pane ];
				opts.resizeWhileDragging = !opts.resizeWhileDragging;
			});
		};
		
		function toggleStateManagement ( skipAlert ) {
			var enable = !myLayout.options.useStateCookie; // OPPOSITE of current setting
			myLayout.options.useStateCookie = enable; // toggle option
	
			if (!enable) { // if disabling state management...
				myLayout.deleteCookie(); // ...clear cookie so will NOT be found on next refresh
				if (!skipAlert)
					alert( 'This layout will reload as options specify \nwhen the page is refreshed.' );
			}
			else if (!skipAlert)
				alert( 'This layout will save & restore its last state \nwhen the page is refreshed.' );
	
			// update text on button
			/*var $Btn = $('#btnToggleState'), text = $Btn.html();
			if (enable)
				$Btn.html( text.replace(/Enable/i, "Disable") );
			else
				$Btn.html( text.replace(/Disable/i, "Enable") );*/
		};
	
		// set EVERY 'state' here so will undo ALL layout changes
		// used by the 'Reset State' button: myLayout.loadState( stateResetSettings )
		var stateResetSettings = {
				north__size:		"auto"
			,	north__initClosed:	false
			,	north__initHidden:	false
			,	south__size:		0
			,	south__initClosed:	false
			,	south__initHidden:	false
			,	west__size:			180
			,	west__initClosed:	false
			,	west__initHidden:	false
			,	east__size:			300
			,	east__initClosed:	false
			,	east__initHidden:	false
		};
	
		var myLayout;
	
		$(document).ready(function () {
	
			// this layout could be created with NO OPTIONS - but showing some here just as a sample...
			// myLayout = $('body').layout(); -- syntax with No Options
			
			myLayout = $('body').layout({
			applyDefaultStyles: false,//æ¯å¦å¯ç¨é»è®¤è®¾ç½® 
			//	enable showOverflow on west-pane so CSS popups will overlap north pane
				west__showOverflowOnHover: true
	
			//	reference only - these options are NOT required because 'true' is the default
			,	closable:				true	// pane can open & close
			,	resizable:				true	// when open, pane can be resized 
			,	slidable:				true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
			,spacing_open:	5
	
			//	some resizing/toggling settings
			, north__size:60
			,	north__slidable:		true	// OVERRIDE the pane-default of 'slidable=true'
			,	north__togglerLength_closed: '100%'	// toggle-button is full-width of resizer-bar
			,   north__resizable:       false
			,	north__spacing_closed:	10		// big resizer-bar when open (zero height)
			,	south__resizable:		false	// OVERRIDE the pane-default of 'resizable=true'
			,	south__spacing_open:	5		// no resizer-bar when open (zero height)
			,	south__spacing_closed:	5		// big resizer-bar when open (zero height)
			,	south__size:				0
			//	some pane-size settings
			,	west__size:				180
			,   west__resizable:       false
			,	west__minSize:			100
			,	east__size:				230
			,	east__minSize:			230
			,   east__resizable:       false  // 控制是否可以拖拽大小
			,	east__maxSize:			Math.floor(screen.availWidth / 2) // 1/2 screen width
			,	center__minWidth:		100
	
			,	useStateCookie:			true
			});
			// if there is no state-cookie, then DISABLE state management initially
			var cookieExists = false;
			for (var key in myLayout.getCookie()) {
				cookieExists = true;
				break;
			}
			if (!cookieExists) toggleStateManagement( true );
	
			// add event to the 'Close' button in the East pane dynamically...
			//myLayout.addCloseBtn('#btnCloseEast', 'east');
	
			// add event to the 'Toggle South' buttons in Center AND South panes dynamically...
			//myLayout.addToggleBtn('.south-toggler', 'south');
	
			// add MULTIPLE events to the 'Open All Panes' button in the Center pane dynamically...
			/*myLayout.addOpenBtn('#openAllPanes', 'north');
			myLayout.addOpenBtn('#openAllPanes', 'south');
			myLayout.addOpenBtn('#openAllPanes', 'west');
			myLayout.addOpenBtn('#openAllPanes', 'east');
			*/
			// 'Reset State' button requires updated functionality in rc29.15
			if ($.layout.revision && $.layout.revision >= 0.032915)
				$('#btnReset').show();
				
				
			// ç»divè®¾ç½®åè§
			$("#westInnerDiv").corner();
			$("#eastInnerDiv").corner();
			//$(".menuBg").corner();
			$(".menuBg").corner("round 3px");
			$(".topMenuBg").corner("round 3px");
	
	 	});
		// .ui-layout-resizer .ui-layout-toggler
		</script>
		
		<!-- start east 手风琴 -->
		<script>
			$(function() {
				$( "#accordion" ).accordion({
					fillSpace: false,
					 autoHeight: true,
					 collapsible: true ,
					 event: 'click' 
				});
			});
			$(function() {
				$( "#accordion1" ).accordion({
					fillSpace: false,
					 autoHeight: true,
					 collapsible: true ,
					 event: 'click' 
				});
			});
			$(function() {
				$( "#accordionResizer" ).resizable({
					minHeight: 130,
					resize: function() {
						$( "#accordion" ).accordion( "resize" );
					}
				});
			});
	 </script>
	 <style type="text/css">
			h4,h5{height:25px;line-height:25px;font-size:11px;margin:0px;}
	 	</style>
	<!-- end east 手风琴 -->
	
	
	<style type="text/css">
<!--
 
.STYLE1 {
	font-size: 12px;
	color: #000000;
}
.STYLE5 {font-size: 12}
.STYLE7 {font-size: 12px; color: #FFFFFF; }
-->
</style> 
	
	
	</head>
	<body style="background-color:#DFE8F6;">
		<!-- manually attach allowOverflow method to pane -->
		<!-- background:url(top_bg4.jpg) left top no-repeat;-->
		<div class="ui-layout-north"  style="background-image:url(layout/development-bundle/themes/cupertino/images/bg40x40.png) ;border:1px solid #aac6ec;overflow:hidden;margin:0px;padding:0px;" onmouseover="myLayout.allowOverflow('north')" onmouseout="myLayout.resetOverflow(this)">
<!--					<div style="position:relative;height:30px;width:100%;border:1px solid red;top:0px;right:0px;">-->
<!--						<div style="position:absolute;top:0px;right:0px;width:65px;;border:1px solid green;">退出系统</div>-->
<!--					</div>-->
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td height="57" background="images/main_03.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
			        <td width="534" height="57" background="images/main_01.gif">&nbsp;</td>
			        <td>&nbsp;</td>
			        <td width="281" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr>
			            <td width="33" height="27"><img src="images/main_05.gif" width="33" height="27" /></td>
			            <td width="248" background="images/main_06.gif"><table width="225" border="0" align="center" cellpadding="0" cellspacing="0">
			              <tr>
			                <td height="17"><div align="right"><img src="images/pass.gif" width="69" height="17" /></div></td>
			                <td><div align="right"><img src="images/user1.gif" width="69" height="17" /></div></td>
			                <td><div align="right"><img src="images/quit.gif" width="69" height="17" style="cursor:hand;" onclick="if(confirm('确定要退出系统？'))location.href='http://localhost:8080/coss/'" /></div></td>
			              </tr>
			            </table></td>
			          </tr>
			        </table></td>
			      </tr>
			    </table></td>
			  </tr>
			</table>
		</div>
		
		<!-- allowOverflow auto-attached by option: west__showOverflowOnHover = true -->
		<div class="ui-layout-west"  style="border:1px solid #aac6ec;padding:2px;">
			<div id="westInnerDiv" style="width:100%;height:100%;background:#CBE4E9;">
				<div style="height:30px;border-bottom:1px solid white;line-height:30px;text-align:center;font-weight:bold;">系统功能</div>
				<div id="accordion1" style="font-size:12px;">
					<h4><a href="#">信息管理</a></h4>
					<div style="height:150px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="daiban" task="articlecontroller/toArticleList.do">信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="newbasic" task="muniu_createBasicInfo">信息录入</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="taotaichaxun" task="muniu_findMuniuList?muniuVO.status=2">信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="lishiqunti" task="muniu_findMuniuList">历史群体查询</a>
							</li>
						</ul>
					</div>
					<h4><a href="#">权限管理</a></h4>
					<div style="height:150px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="peizhongluru" task="muniu_createPeizhongInfo">用户信息查询</a> 
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="peizhongchaxun" task="muniu_findPeizhongList">角色信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="jieduluru" task="muniu_createChanduInfo">菜单信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="jieduchaxun" task="muniu_findChanduList">用户信息查询</a>
							</li>
<!--							<li style="height:23px;line-height:23px;">-->
<!--								<a class="leftLinkDiv" onclick="addTab(this)" id="testlist" task="test_getList">系谱查询</a>-->
<!--							</li>-->
						</ul>
					</div>
					<h4><a href="#">系统管理</a></h4>
					<div style="height:150px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="tztcluru" task="muniu_createTztcInfo">用户信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="tztcchaxun" task="muniu_findFayuList">用户信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="quntitongji" task="muniu_findQuntiTongji">用户信息查询</a>
							</li>
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="getitongji" task="muniu_findFayuList">用户信息查询</a>
							</li>
						</ul>
					</div>
					<h4><a href="#">业务管理</a></h4>
					<div style="height:150px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;line-height:23px;">
								<a class="leftLinkDiv" onclick="addTab(this)" id="cssd" task="muniu_createParam">参数设定</a>
							</li>
						</ul>
					</div>
				</div>
				
			</div>
		</div> 
<!--		<div class="ui-layout-south" style="text-align:center;border:1px solid highlight;">帮助说明</div>	-->
		
		<div class="ui-layout-east"  style="border:1px solid #aac6ec;padding:2px;">
			<div id="eastInnerDiv" style="width:100%;height:100%;background:#CBE4E9;">
				<div style="height:30px;border-bottom:1px solid white;line-height:30px;text-align:center;font-weight:bold;">帮助说明</div>
				<div id="accordion" style="font-size:12px;">
					<h4><a href="#">通知公告</a></h4>
					<div style="height:160px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">欢迎使用肉牛育种生产信息管理系统</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">咨询系统使用请打电话15048359918</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">请于每日18:00打电话</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">系统更换IDC服务商，暂停服务</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">放假通知，敬请谅解</li>
						</ul>
					</div>
					<h4><a href="#">常见问题</a></h4>
					<div style="height:160px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">在基本信息查看页面可以上传牛的图片</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">哪里可以上传牛的图片?</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">哪里可以上传牛的图片?</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">哪里可以上传牛的图片?</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">哪里可以上传牛的图片?</li>
						</ul>
					</div>
					<h4><a href="#">名词释义</a></h4>
					<div style="height:160px;padding:0px;">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">基本信息录入可以录入母牛的基本属性</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">体重体尺录入可以录入母牛的生长发育</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">配种录入可以录入母牛的配种情况</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">接犊录入可以录入母牛的产犊情况</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">参数设定可以调整预产期系数值</li>
						</ul>
					</div>
					<h4><a href="#">客服方式</a></h4>
					<div style="height:80px;padding:0px">
						<ul style="margin:0px; padding:0px 0px 0px 3px;">
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">网站：www.baidu.com</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">固定电话：0471-8670001</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">QQ：123456789</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">MSN：</li>
							<li style="height:23px;border-bottom:1px dashed #ccc;line-height:23px;white-space: nowrap;text-overflow:ellipsis;overflow:hidden;">Email：</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="ui-layout-center" style="border:1px solid #aac6ec ;margin:0px;padding:0px;background:url(images/welcome_bg.jpg);">
			<!-- <iframe id="contentFrame" frameBorder="0" style="height:99%;width:100%;margin:0px;padding:0px;" src="manipulation.html"></iframe> -->
			
			<div style="margin:0px;padding:0px;">
			
				<div id="dialog" title="Tab data">
					<form>
						<fieldset class="ui-helper-reset">
							<label for="tab_title">Title</label>
							<input type="text" name="tab_title" id="tab_title" value="" class="ui-widget-content ui-corner-all" />
							<label for="tab_content">Content</label>
							<textarea name="tab_content" id="tab_content" class="ui-widget-content ui-corner-all"></textarea>
						</fieldset>
					</form>
				</div>
			 
			
				<div id="tabs"> 
					<ul>
						<li><a href="#tabs-1">欢迎页面</a> <span class="ui-icon ui-icon-close">Remove Tab</span></li>
						
					</ul>
					<div id="tabs-1" style="padding:0px;height:80%;float:left;width:100%;vertical-align: middle;">
						<div style="width:100%;height:100%;overflow:auto;">
							<div class="welcomeDiv"  onclick="addTab(this)" id="daiban" task="muniu_findMuniuList?muniuVO.status=1">当年在群查询</div>						
							<div class="welcomeDiv" onclick="addTab(this)"  id="print" task="muniu_findPrintInfo">母牛档案查询</div>
							<div class="welcomeDiv"  onclick="addTab(this)" id="quntitongji" task="muniu_findQuntiTongji">群体数据统计</div>
							<div class="welcomeDiv" onclick="addTab(this)"  id="taotaichaxun" task="muniu_findMuniuList?muniuVO.status=2">淘汰查询</div>
							<div class="welcomeDiv" onclick="addTab(this)" id="newbasic" task="muniu_createBasicInfo">基本信息录入</div>
							<div class="welcomeDiv" onclick="addTab(this)" id="peizhongluru" task="muniu_createPeizhongInfo">配种信息录入</div>
							<div class="welcomeDiv" id="lishiqunti" task="muniu_findMuniuList">历史在群查询</div>
							<div class="welcomeDiv" id="tztcluru" task="muniu_saveFayuList">体重体尺录入</div>
							<div class="welcomeDiv" id="jieduluru" task="muniu_createChanduInfo">接犊信息录入</div>
						</div>
					</div>
					
				</div>
			
		</div><!-- End demo -->

		</div>
	
	</body>
</html>