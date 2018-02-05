package com.hp.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.hp.entity.HDFSFile;
import com.hp.service.HDFSService;
import com.hp.service.impl.HDFSServiceImpl;
import com.hp.util.HDFSUtil;
import com.hp.util.PageUtil;

import sun.net.www.content.audio.basic;

/**
 * Servlet implementation class ShowFile
 */
@WebServlet("/ShowFile")
@MultipartConfig
public class ShowFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HDFSService hdfsService=new HDFSServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int nowPage =Integer.parseInt(request.getParameter("nowPage"));
		int everyPageCount=8;
		String path=request.getParameter("path");
		HDFSFile h=new HDFSFile();
		h.setFileName(path);
		List<HDFSFile> list=hdfsService.select(h);
		Integer parentId=null;
		if (list!=null && list.size()>0) {
			parentId=list.get(0).getFileId(); //前面一个的id作为下一个的parentId
		}
		int totalCount = hdfsService.getCount(parentId);
		List<HDFSFile> fileInfo = hdfsService.selectAll(parentId,(nowPage-1)*everyPageCount,everyPageCount);
		
		PageUtil pu=new PageUtil(totalCount, everyPageCount);
		pu.getPageView(nowPage, 6, totalCount);
		
		request.setAttribute("totalPage", pu.getTotalPage());
		request.setAttribute("startPage", pu.getFirstIndex());
		request.setAttribute("endPage", pu.getEndIndex());
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("fileInfo", fileInfo);
		request.setAttribute("path", path);
		request.getRequestDispatcher("indexhdfs.jsp").forward(request, response);
	}
	/**
	 * 用于从hdfs中下载文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String filePath=request.getParameter("path");
		
		FileSystem fs=HDFSUtil.setPro();

		HDFSUtil.downloadFile(fs, filePath,"F:/output");
		request.getRequestDispatcher("successUpdate.jsp").forward(request, response);
	}
	/**
	 * 上传文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Part part=request.getPart("fileName");
		
		String fileName=part.getSubmittedFileName();
		//得到要在hdfs中创建的文件名称
		String filePath=request.getParameter("filePath");
		InputStream in=part.getInputStream();
		byte[] b=new byte[4096];
		in.read(b);
		String hdfsPath= filePath+"/"+fileName;
		
		FileSystem fs=HDFSUtil.setPro();
		//更新数据库
		HDFSFile hdfsFile = new HDFSFile();
		hdfsFile.setFileName(filePath);
		List<HDFSFile> list=new ArrayList<>();
			//float的截取小数位数
		DecimalFormat df=new DecimalFormat("#.00");
		Float size=Float.parseFloat(df.format((b.length*1.0/1024)));
		List<HDFSFile> parent=hdfsService.select(hdfsFile);
		int parentId=parent.get(0).getFileId();
		boolean isDir=false;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(date);
		HDFSFile hdfsFiles = new HDFSFile(fileName,size,date,parentId,isDir); 
		list.add(hdfsFiles);
		hdfsService.insert(list);
		//更新hdfs
		HDFSUtil.add(fs, hdfsPath, in);
		request.getRequestDispatcher("successUpdate.jsp").forward(request, response);
	}
	protected void readFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String fileName=(String) request.getParameter("path");
		FileSystem fs=HDFSUtil.setPro();
		//删除hdfs中的数据
		String file=HDFSUtil.read(fs, fileName);
		request.setAttribute("text", file);
		request.getRequestDispatcher("HDFS.jsp").forward(request, response);
		
	}
	/**
	 * 删除文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String fileName=(String) request.getParameter("path");
		FileSystem fs=HDFSUtil.setPro();
		String filePath=fileName;
		String newPath=fileName.substring(0, fileName.lastIndexOf("/"));
		String newfileName=fileName.substring(fileName.lastIndexOf("/")+1,fileName.length());
		Path path=new Path(filePath);
		//删除数据库中的信息
		HDFSFile hdfsFile = new HDFSFile();
		hdfsFile.setFileName(newfileName);
		List<HDFSFile> parent=hdfsService.select(hdfsFile);
		int fileId=parent.get(0).getFileId();
		hdfsService.delete(fileId);
		//删除hdfs中的数据
		if (HDFSUtil.delete(fs, path)) {
			request.getRequestDispatcher("ShowFile?method=showAll&nowPage=1&path="+newPath).forward(request, response);
		}else {
			request.getRequestDispatcher("false.jsp").forward(request, response);
		}
	}
}
