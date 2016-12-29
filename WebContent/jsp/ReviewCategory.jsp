<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bizzlers.foundation.platform.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.bizzlers.foundation.FDE.ClassResultSet"%>
 <%@page import="java.util.Vector"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Review Category </title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/Bizzlers/css/main.css" />

 <% 
  if(request.getSession().getAttribute("session_name") == null){ 
response.sendRedirect("http://localhost:8080/Bizzlers/html/loginpage.html"); 
} 
%>

<script type="text/javascript">
function sendinfo(i,cid)
{

	
	
	var getSelectedIndex = document.selform.catName.selectedIndex ;
	var getSelectedOptionText = document.selform.catName[getSelectedIndex].text;

	var res = confirm(" Map to "+getSelectedOptionText+" category ?? ");
	
	if (res == true )
		document.location.href='/Bizzlers/jsp/ChangeCategory.jsp?oldId='+cid+"&newName="+getSelectedOptionText;
	else
		document.location.href='/Bizzlers/ReviewCat';
		
	
	
}
</script>
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
<li><a href="http://localhost:8080/Bizzlers/jsp/adminprofile.jsp" class="selected">Home</a></li>
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
						<li><a href="http://localhost:8080/Bizzlers/jsp/adminprofile.jsp"> Home </a></li>
						
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
				<div class="h4gen">
<%
	@SuppressWarnings("unchecked")
	Vector<ClassResultSet> resultSets = (Vector<ClassResultSet>)request.getAttribute("result");

if (resultSets.size() <= 0 )
	out.println(" <center> No categories pending for review </b></center>");
else{
	
	
	out.print("<ol class=none>");
	out.println(" Total "+ resultSets.size() +" categories pending for review <br/> <br/>");
	Category category = new Category();
	List<String> names = new ArrayList<String>();
	names = category.getAllValidCategoryList();
	
	
			
	for(int i = 0 ;  i < resultSets.size() ; i ++ ){

		    out.print(" <br/> <fieldset margin-left = 10 > <br/>");
			out.print("<li> Title : "+ resultSets.elementAt(i).getFieldTwo());
			out.print(" <br/> Description : "+ resultSets.elementAt(i).getFieldThree());
			out.print(" <br/><br/> <a href=http://localhost:8080/Bizzlers/jsp/AllowCategory.jsp?id="+ resultSets.elementAt(i).getFieldOne()+"&name="+ resultSets.elementAt(i).getFieldTwo()+"> Allow  </a> <br/> " ) ;
			
			out.print("<form id=selform name=selform>");
			out.print("  Change to ");
			out.print("<select name=catName ");
			Iterator<String> iter = names.iterator();
			while(iter.hasNext())
				out.print("<option>"+ iter.next() +"</option>");

			 out.print("</form>");
			
			out.print("</select> <a name=chg href=# onclick='sendinfo("+i+","+resultSets.elementAt(i).getFieldOne()+")'> category  </a>  ");
			
			out.print(" <br/>  This can't be any category <a href=http://localhost:8080/Bizzlers/DenyCategory?id="+ resultSets.elementAt(i).getFieldOne()+"> Delete it  </a>  " ) ;
			
			out.print("<br/><br/> </fieldset>");
		
	}//while
	
}//for
	out.print("</ol>");


%>				</div>
				
			</div>
			<br class="clearfix" />
		</div>   
		
	
		<div id="sidebar">
			<div class="box">
				<!--  $$$$$$$$$ AD $$$$$$$$$$$$
				-->

			</div>
			
			<div class="box">
			
				<!--  $$$$$$$$$ AD $$$$$$$$$$$$
				-->
			
			
				</div>
			
			
		</div>
		<br class="clearfix" />
	</div>
	
	<div id="page-bottom">
		<div id="page-bottom-content">
			<h3> Bizzlers </h3>
				<a href="http://localhost:8080/Bizzlers/jsp/logout.jsp"> Logout </a> <br/>
		</div>
		<div id="page-bottom-sidebar">
			<h3>Connect with us</h3>
			<img src="" alt=fb></img> <img src="" alt=twitter></img> 
			<ul class="list">
			
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