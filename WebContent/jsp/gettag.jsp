<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bizzlers.net.*"%>
<%
    GetTag db = new GetTag();
 
    String query = request.getParameter("q");
 
    List<String> list = db.getData(query);

    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
        String l = (String)iterator.next();
        out.println(l);
    }
%>
