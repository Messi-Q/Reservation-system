<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全国菜品热度</title>
</head>
<body>
	 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 800px;height:600px;margin: 0 auto"></div>

    <script src="js/echarts.min.js"></script>
    <script src="js/china.js"></script>
    <script>
        function randomData() {
            return Math.round(Math.random()*1000);
        }

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
                data:[
                      {name: '北京',value: '北京烤鸭|image/116.jpg|10010'},
                      {name: '天津',value: randomData() },
                      {name: '上海',value: randomData() },
                      {name: '重庆',value: randomData() },
                      {name: '河北',value: randomData() },
                      {name: '河南',value: randomData() },
                      {name: '云南',value: randomData() },
                      {name: '辽宁',value: randomData() },
                      {name: '黑龙江',value: randomData() },
                      {name: '湖南',value: randomData() },
                      {name: '安徽',value: randomData() },
                      {name: '山东',value: randomData() },
                      {name: '新疆',value: '烤羊肉串|image/3617.jpg'},
                      {name: '江苏',value: randomData() },
                      {name: '浙江',value: randomData() },
                      {name: '江西',value: randomData() },
                      {name: '湖北',value: randomData() },
                      {name: '广西',value: randomData() },
                      {name: '甘肃',value: randomData() },
                      {name: '山西',value: randomData() },
                      {name: '内蒙古',value:randomData()},
                      {name: '陕西',value: randomData() },
                      {name: '吉林',value: randomData() },
                      {name: '福建',value: randomData() },
                      {name: '贵州',value: randomData() },
                      {name: '广东',value: randomData() },
                      {name: '青海',value: randomData() },
                      {name: '西藏',value: randomData() },
                      {name: '四川',value: randomData() },
                      {name: '宁夏',value: randomData() },
                      {name: '海南',value: randomData() },
                      {name: '台湾',value: randomData() },
                      {name: '香港',value: randomData() },
                      {name: '澳门',value: randomData() }
                  ],
                  tooltip:{
                      formatter:function(param) {
                          var arr = param.data.value.split("|");
                          return "<img width='250px' height='150px' src=" + arr[1] + "><br/>" + arr[0] + arr[2];
                      }

                  }

              }]
        }

        myChart.setOption(option);
    </script>
</body>
</html>