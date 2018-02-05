<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.hp.entity.MapInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中国地图</title>
</head>
<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 800px;height:600px;margin: 0 auto"></div>
    <script src="js/echarts.min.js"></script>
    <script src="js/china.js"></script>
    <script>
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
       
        var option = {
            title: {
                text: '全国菜品推荐',
                left: 'center'
            },
            tooltip:{
                trigger:'item'
            },
            visualMap: {
                min: 0,
                max: 2500,
                show:false
            },
            series: [{
                type: 'map',
                map: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                tooltip : {
       				 formatter : function (params) {
         		     var attr=params.data.value.split("|");
         		     return "<img width='200px' src='"+attr[0] +"'><br/>"+attr[1]+"<font color='red'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+attr[2]+"</font>";
        }
    },
                data:[
                      <%
                      List<MapInfo> list=(List)request.getAttribute("mapInfo");
                      for(int i=0;i<list.size();i++){
                    	  %>
                    	  <%=list.get(i)%>
                    	  <%
                      }
                      %>
                      ]
                   }]
        }

        myChart.setOption(option);
    </script>
</body>
</html>