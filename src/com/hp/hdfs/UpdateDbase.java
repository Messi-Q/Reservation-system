package com.hp.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
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
import org.apache.hadoop.hdfs.server.namenode.web.resources.NamenodeWebHdfsMethods;

import com.hp.entity.HDFSFile;
import com.hp.service.HDFSService;
import com.hp.service.impl.HDFSServiceImpl;
import com.hp.util.HDFSUtil;

/**
 * Servlet implementation class ShowFile
 */
@WebServlet("/UpdateDbase")
@MultipartConfig
public class UpdateDbase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HDFSService  hdfsService=new HDFSServiceImpl();
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
	public void update(String path) throws IOException{
		// TODO Auto-generated method stub
		FileSystem fs=HDFSUtil.setPro();
		HDFSFile hdfsFile=new HDFSFile();
		hdfsFile.setFileName(path);
		List<HDFSFile> list=hdfsService.select(hdfsFile);
		List<HDFSFile> hdfsFiles=null;
		if (list!=null && list.size()>0) {
			hdfsFiles= HDFSUtil.readForDbase(fs,path,list.get(0).getFileId());
		}else {
			hdfsFiles= HDFSUtil.readForDbase(fs,path,null);
		}
		hdfsService.insert(hdfsFiles);
		for (int i = 0; i < hdfsFiles.size(); i++) {
			if (hdfsFiles.get(i).isDir()) {
				update(hdfsFiles.get(i).getFileName());
			}
		}
	}
}
