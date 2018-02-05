<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	</head>
	<frameset rows="67px,*" border="0px">
		<frame src="top.jsp?adminName=<%=request.getAttribute("name")%>" noresize="noresize"/>
		<frameset cols="231px,*">
			<frame src="left.jsp?adminName=<%=request.getAttribute("name")%>&adminId=<%=request.getAttribute("AdminId")%>" noresize="noresize" name="left"/>
			<frame src="right.html" noresize="noresize" name="right"/>
		</frameset>
	</frameset>
</html>