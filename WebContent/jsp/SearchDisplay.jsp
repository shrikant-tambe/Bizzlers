
<%@page import="java.util.Vector"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Search Results </title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />
</head>

<body >
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
				<!--   	  
				<ul class="svertical">
						<li><a href="http://localhost:8080/Bizzlers/jsp/userprofile.jsp"> Home </a></li>
						<li><a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a></li>
				</ul>
				 -->
				 
				 <!-- Put code for pop up ad here -->
				 
				 
				</div>
				
				
			<div class="box" id="content-box2">
			
				<form method="get" action="http://localhost:8080/Bizzlers/Search">
			<div class="form-submit" >
			
			 <input class=inputtext type="text" name="query" size="30"/>
			<input class=inputsubmit type="submit" value="Search" />
			</div>
			</form>
			
				    
			    <br/> 
				  

<p>

<%
	@SuppressWarnings("unchecked")
	Vector<ClassResultSet> resultSets = (Vector<ClassResultSet>)request.getAttribute("result");
	
	
	
	if (resultSets.size() <= 0 )
		out.println(" <h4> <center> Sorry no results found for <b> \" " + request.getParameter("query") + " \" </b></center> </h4>");
	else{
		
		
		int start = resultSets.lastElement().getFieldOne();
	    int displayCount = resultSets.lastElement().getDataType();
		String printString =  null ;
		int size = resultSets.size() ;
		
		size=size-1; // 1 element contains display information
		

		out.print("<ol class=none>");
		out.println(" <h4> Total "+ size +" results found </h4>");
		 
	for(int i = start ; i < size &&  i < displayCount ; i ++ ){
	
		printString = resultSets.elementAt(i).getAllTogether() ;
	
		StringTokenizer st = new StringTokenizer(printString, "|");
		boolean isFirstPrinted = false ;
	
    	while(st.hasMoreElements()){
    		out.print("<li  >");
    		out.print("<div >");
    		if(isFirstPrinted == false )	{
				out.print("<br/> <h4> <a href=http://localhost:8080/Bizzlers/DisplayDetails?id="+ resultSets.elementAt(i).getFieldOne() +"&dataType="+ resultSets.elementAt(i).getDataType()+ ">" + st.nextElement().toString() + "   </a> </h4> " ) ;
				isFirstPrinted = true ;
    		}		
    		else
    			out.print( st.nextElement().toString() ) ;
    		
    	}//while
    	
	}//for
		out.print("</ol>");
			
	}//else
	
%>
</p>
				
		</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">

				<!--  %%%%%%%%%%%%%%%%%%%%%%%%%%%AD%%%%%%%%%%%%%%%%%%%%%%% -->

			</div>
			 
			<div class="box">
			
				<!--  ################# Ad ##########################   -->
					
			</div>
			 
			 
			 
		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3> Bizzlers </h3>
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
