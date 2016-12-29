<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page import="java.util.Vector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html");} %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of products</title>

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />

		<script type="text/javascript" src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"></script>
		<script type="text/javascript"  charset="utf-8">
		$(document).ready(function(){

			var jVal = {

				'pname' : function() {

					$('body').append('<div id="nameInfo" class="info"></div>');

					var nameInfo = $('#nameInfo');
					var ele = $('#pname');
					var pos = ele.offset();
					

					nameInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+25
					});

					if(ele.val().length < 3) {
						jVal.errors = true;
							nameInfo.removeClass('correct').addClass('error').html('&larr; name should be of at least 3 letters').show();
							ele.removeClass('normal').addClass('wrong');
					} 
					else {
							nameInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},

				
						'desc' : function() {

					$('body').append('<div id="aboutInfo" class="info"></div>');

					var aboutInfo = $('#aboutInfo');
					var ele = $('#des');
					var pos = ele.offset();

					aboutInfo.css({
						top: pos.top-3,
						left: pos.left+ele.width()+12
					});

					if(ele.val().length < 1) {
						jVal.errors = true;
							aboutInfo.removeClass('correct').addClass('error').html('&larr; please enter description').show();
							ele.removeClass('normal').addClass('wrong').css({'font-weight': 'normal'});
					} else {
							aboutInfo.removeClass('error').addClass('correct').html('&radic;').show();
							ele.removeClass('wrong').addClass('normal');
					}
				},
				

				'sendIt' : function (){
					if(!jVal.errors) {
						$('#jform').submit();
					}
				}
			};
			
			
			$('#send').click(function (){
				var obj = $.browser.webkit ? $('body') : $('html');
				obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
					jVal.errors = false;
					jVal.pname();
					jVal.desc();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#pname').change(jVal.pname);	
			$('#des').change(jVal.desc);

		});
		</script>

    
</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Bizzlers</a></h1>
		</div>
		<div id="slogan">
			<h2> See your business growing with us  </h2>
		</div>
		<div id="slogan2">
			<h2> </h2>
		</div>
	</div>
	<div class="innertube">

<ul class="semiopaquemenu">
<li><a href="#" > &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp" class="selected">Home</a></li>
<li><a href="#" >News</a></li>

<li><a href="#">Feedback</a></li>
<li><a href="#">About Us</a></li>
<li><a href="#">Contact Us</a></li>
</ul>


<div class="bottombar"></div>

</div>
	
	<div id="page">
		<div id="content">
		 
			
			
				  <div class="box" id="content-box1">
				  	  
				<ul class="svertical">
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a></li>
						<%
						out.print("<li> <a href=http://localhost:8080/Bizzlers/ViewBusinessProfile?id="+ request.getSession().getAttribute("currentbid")  + "> Back </a></li>");
					 %>
				</ul>
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<div class="form-submit" >
			
			 <input class=inputtext type="text" name="query" size="30"/>
			<input class=inputsubmit type="submit" value="Search" />
			</div>
			</form>
		
	
				    
			    <br/> 
				  <h4>  Add Details   </h4>
		<h5> 
 				
<form id=jform  method="post" action="http://localhost:8080/Bizzlers/addproduct">
		<table>
			<tr>
				<td align="right">Product Name *:</td>
				<td align="left"><input type="text" name="pname" id="pname" /></td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td align="right"> Description *: </td>
				<td align= "left"> <textarea rows="6" cols="36" name="des" id="des" ></textarea></td>
			</tr>

<tr><td><br/></td></tr>
<tr><td><br/></td></tr>

			<tr> <td align="right"> <input class=inputsubmit type=submit value='Add' id=send /> </td>
			<td align="left"> <input class=inputsubmit  type=reset value='Clear' /> </td>
			</tr>
			
		</table>
		<br/><br/>
		
	 <I> Note : Fields with * are compulsary </I>
</form>
			</h5>	
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">

			</div>
		
			<div class="box">
				
				<!--  ##############  ad s--> 
				
			</div>

		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3> Bizzlers </h3>
				<a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a> <br/>
				<a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a> <br/>
		</div>
		<div id="page-bottom-sidebar">
			<h3>Connect with us</h3>
			<img src="" alt=fb></img> <img src="" alt=twitter></img> 
			<ul class="list">
				<li class="first"><a href="#"> &nbsp;</a></li>
				<li><a href="#">Contact us</a></li>
				<li class="last"><a href="#">About Us</a></li>
			</ul>
		</div>
		<br class="clearfix" />
	</div>

<div id="footer">
	Bizzlers.com
</div>
</div>
</body>
</html>