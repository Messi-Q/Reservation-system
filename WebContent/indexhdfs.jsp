<%@page import="com.hp.entity.HDFSFile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/right_frame.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sellList.css">
	</head>
	<body>
		<div class="main">
		<div class="top"></div>
		<div class="list">
			文件信息
		</div>
		<div class="body">
			<div id="head" style="float: left;">
			<input typt="text" style="border: 1px #ccc solid; border-radius: 5px; margin:10px; padding-left: 20px; width: 600px;height: 40px;font-size: 20px;line-height: 40px;" id="select" value="<%=request.getAttribute("path")%>"/>
			<input type="button" style="border-radius: 5px;width: 45px;height: 42px; text-align: center;" onclick="selectAll()" value="查询"/>
			</div>
			<div style="float: left;margin-left: 20px;margin-top: 20px;">
			<form action="ShowFile?method=upload" method="post" enctype="multipart/form-data">
			<input type="file" value="选择文件" name="fileName"/>
			<input type="text" style="visibility: hidden;width: 0px;" name="filePath" value="<%=request.getAttribute("path")%>"></input>
			<input type="submit" value="确定"/>
			</form>
			</div>
					<table>
						<tr>
							<th>文件名</th>
							<th>文件大小</th>
							<th>日期</th>
							<th colspan="3">操作</th>
						</tr>
					<%
						List<HDFSFile> fileInfo =(List)request.getAttribute("fileInfo");
					if(fileInfo!=null){
						for(int i=0;i<fileInfo.size();i++){
					%>
						<tr class=tr2>
							<td width="30%"><%=fileInfo.get(i).getFileName()%></td>
							<td width="20%"><%=fileInfo.get(i).getSize() %>&nbsp;&nbsp;KB</td>
							<td width="20%"><%=fileInfo.get(i).getUploadtime()%></td>
							<%
								if(fileInfo.get(i).isDir()){
							%>
							<td width="10%" colspan=3><a href="ShowFile?method=showAll&nowPage=1&path=<%=request.getAttribute("path")+"/"+fileInfo.get(i).getFileName()%>">打开文件</a></td>
						<% }else{
							%>
							<td width="10%"><a href="ShowFile?method=delete&path=<%=request.getAttribute("path")+"/"+fileInfo.get(i).getFileName()%>">删除文件</a></td>
							<td width="10%"><a href="ShowFile?method=download&path=<%=request.getAttribute("path")+"/"+fileInfo.get(i).getFileName()%>">下载文件</a></td>
							<td width="10%"><a href="ShowFile?method=readFile&path=<%=request.getAttribute("path")+"/"+fileInfo.get(i).getFileName()%>">查看详情</a></td>
							<%
						}%>
						</tr>
						<%
						} 
					}
						%>
				<tr>
				<td colspan="5">
				<a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=1">[首页]</a>
				<% 
				int endPage=(int)request.getAttribute("endPage");
				int startPage=(int)request.getAttribute("startPage");
				int totalPage=(int)request.getAttribute("totalPage");
				int nowPage=(int)request.getAttribute("nowPage");
				
				for(int i=startPage;i<=endPage;i++){
					if(i==nowPage){
						%>
						<a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=<%=i %>" style="color: red;">第<%=i %>页</a>&nbsp;&nbsp;
						<%
					}else{
				%>
				<a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=<%=i %>">第<%=i %>页</a>&nbsp;&nbsp;
				<%} } %>
				<a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=<%=totalPage %>">[尾页]
				</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=<%=(nowPage-1)>0?(nowPage-1):1 %>">[上一页]
				</a><a href="ShowFile?method=showAll&path=<%=request.getAttribute("path")%>&nowPage=<%=(nowPage+1)>totalPage?totalPage:(nowPage+1) %>">[下一页]</a></td>
 			</tr>
					</table>		
		</div>
		</div>
	</body>
	<script type="text/javascript">
		function selectAll(){
			var select=document.getElementById("select").value;
			window.location=("ShowFile?method=showAll&nowPage=1&path="+select);
		}
	</script>
</html>