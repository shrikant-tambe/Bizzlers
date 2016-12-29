<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@page import="com.bizzlers.foundation.platform.News" %>
<%@ page import="java.util.Vector" %>
<%@page import="java.text.ParseException" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Bizzlers.com </title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />
<script type="text/javascript"  src="http://localhost:8080/Bizzlers/js/jq142.js" charset="utf-8"> </script>
<script type="text/javascript"  charset="utf-8">
		$(document).ready(function(){

			var jVal = {

				'email' : function() {

					
					var nameInfo = $('#nameInfo');
					var ele = $('#username');
					var pos = ele.offset();
					var patt = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
					

					if(!patt.test(ele.val())) {
						jVal.errors = true;
						nameInfo.removeClass('correct').addClass('error').html('please enter valid email').show();
						ele.removeClass('normal').addClass('wrong');
					}
					else {
							nameInfo.removeClass('error').addClass('correct').html('').show();
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
					jVal.email();
					jVal.sendIt();
				});
				return false;
			});

			
			$('#username').change(jVal.email);
					

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
<li><a href="#" class="selected">Home</a></li>
<li><a href="http://localhost:8080/Bizzlers/ViewAdminNews" >News</a></li>

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
						<li><a href="#"> Products </a></li>
						<li><a href="#"> Services </a></li>
						<li><a href="#"> Businesses </a></li>
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
				<h3> Bizzlers </h3>
				<p>
					Welcome to enterprise web application which will establish online network of businesses and consumers in order to leverage marketing operations of businesses and enables customers to quickly find best products and/or services available.
				</p>
				
			</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">
				<h3> Explore your business  </h3>
				<div id="search">
				<form id=jform method="post" action="http://localhost:8080/Bizzlers/Login">
					<table>

						<tr><td>Email</td><td> <input class="inputtext" type="text" name="username" id=username size="18"/></td></tr>
						<tr><td> </td><td><div id="nameInfo">  </div> </td></tr>
						<tr><td>Password</td><td> <input class="inputtext"  type="password" name="password" size="18"/></td></tr>
						<tr><td> </td><td> </td></tr>

						<tr><td></td><td align="right"> <input class="inputsubmit" type="submit" value=" Submit " id=send /></td></tr>
					</table>
				</form>
				<br/>
				
				 &nbsp;  &nbsp; <a href="#"> Forgot Password ? </a>  &nbsp; &nbsp; &nbsp; <a href="/Bizzlers/html/registerCust.html"> Register Here </a>
				 <br/>  <br/>
				</div>
				
			</div>
			<div class="box">
				<h3> News </h3>
<%
	Vector<ClassResultSet> list = new Vector<ClassResultSet>();

News newsObj = new News();

try {
	list = newsObj.getNewsByBid(1);
} catch (ParseException e) {
	e.printStackTrace();
}

if(list.size() <= 0 )
	out.print("<h3> No recent news </h3>");

else{

	out.print("<ul>");
	out.print("<marquee direction=up scrollamount=4 >");
	 out.print("<div class=date-list>");
	out.print("	<ul class=list date-list> ");
	int limit = list.size();
	if(list.size() > 3 )
		limit = 3;


	for(int i = 0 ; i < limit ; i ++ ){
		out.print("<li><h4> <span class=date>"+list.elementAt(i).getFieldFour()+"</span>   " + list.elementAt(i).getFieldTwo() + "</h4><br/><h5>"+ list.elementAt(i).getFieldThree() +"</h5></li>" );	
	}
	out.print("</ul> ");
	out.print("</div>");
	
	out.print("</marquee>");
out.print("</ul>");
}

list.removeAllElements();
%>			
			</div>
		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3>Bizzlers </h3>
			<p>
			 
			</p>
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
