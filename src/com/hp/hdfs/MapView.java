package com.hp.hdfs;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.fs.Path;

import com.hp.entity.MapInfo;
import com.hp.mapreduce.MapReduceImp;
import com.hp.util.HDFSUtil;
import com.hp.util.ProvinceUtil;

/**
 * Servlet implementation class MapView
 */
@WebServlet("/MapView")
public class MapView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method=(String)request.getParameter("method");
		try {
			Method m=this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void showMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		List<MapInfo> list1= HDFSUtil.MapReduceResult(HDFSUtil.setPro(), "/user/hadoop/output/part-r-00000");
		List<MapInfo> list=ProvinceUtil.addImg(list1);
		List<String> mapInfo=new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			mapInfo.add("{ name:'"+list.get(i).getProvince()+"',value:'"+list.get(i).getImgPath()+"|"+list.get(i).getFoodName()+"|"+list.get(i).getHot()+"'},");
		}
		request.setAttribute("mapInfo", mapInfo);
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}
	public void mapReduce(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//删除output文件夹
		HDFSUtil.delete(HDFSUtil.setPro(), new Path("/user/hadoop/output"));
		//开始MapReduce
		MapReduceImp.start("/user/hadoop/work");
		request.getRequestDispatcher("MapView?method=showMap").forward(request, response);
	}
}
