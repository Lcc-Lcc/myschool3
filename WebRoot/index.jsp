<%@page import="entity.Grade"%>
<%@page import="service.impl.GradeDaoServiceImpl"%>
<%@page import="service.GradeDaoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
      GradeDaoService gd=new GradeDaoServiceImpl();
        List<Grade> list=gd.selectAll();
        if(list!=null)
        {
            for(Grade grades:list)
            {
               out.print("年级名称："+grades.getGradename());
            }
        }
     %>
     <%
     int result=gd.deleteGrade(4);
     if(result>0)
     {
         out.print("<script>alert('删除成功')</script>");
     }
     else
     {
         out.print("<script>alert('删除失败')</script>");
     }
     
      %>
  </body>
</html>
