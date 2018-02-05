package com.hp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import com.hp.entity.HDFSFile;
import com.hp.entity.MapInfo;

public class HDFSUtil {
	public static void add(FileSystem fs, String hdfsPath, String localPath) throws IOException {
		File f=new File(localPath);
		String hpath=hdfsPath+"/"+f.getName();
		Path path=new Path(hpath);
		
		if (f.exists() && !fs.exists(path)) {
			
		FileInputStream in=new FileInputStream(f);
		OutputStream out=fs.create(path);
		IOUtils.copyBytes(in, out, 4096, true);

		}
	}
	public static void add(FileSystem fs, String hdfsPath, InputStream in) throws IOException {
		
		Path path=new Path(hdfsPath);
		
		if (!fs.exists(path)) {
			
		OutputStream out=fs.create(path);
		IOUtils.copyBytes(in, out, 4096, true);

		}
	}
	public static List<HDFSFile> readFile(FileSystem fs,String path) throws IOException {
		FileStatus[] fileStatus=fs.listStatus(new Path(path));
		List<HDFSFile> fileInfo=new ArrayList<>();
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String date=dateFormat.format(new Date());
		for(FileStatus fStatus:fileStatus){
			String name=fStatus.getPath().getName();
			Float size=(float)(fStatus.getLen()*1.0/1024);
			
			HDFSFile fi=new HDFSFile(name,size,new Date());
			fileInfo.add(fi);
		}
		fs.close();
		return fileInfo;
		
	}
	public static List<HDFSFile> readForDbase(FileSystem fs,String path,Integer parentId) throws IOException {
		FileStatus[] fileStatus=fs.listStatus(new Path(path));
		List<HDFSFile> fileInfo=new ArrayList<>();
//		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String date=dateFormat.format(new Date());
		
		for(FileStatus fStatus:fileStatus){
			String name=fStatus.getPath().getName();
			long length=fStatus.getLen();
//			NumberFormat numberFormat=DecimalFormat.getInstance();
//			numberFormat.setMaximumFractionDigits(2);
//			numberFormat.setMinimumFractionDigits(2);
			DecimalFormat df=new DecimalFormat("#.00");
			Float size=Float.parseFloat(df.format((length*1.0/1024)));
			String newPath=null;
			if ("/".equals(path)) {
				newPath=path+name;
			}else {
				newPath=path+"/"+name;
			}
			
			HDFSFile fi=null;
			if (HDFSUtil.isDir(newPath)) {
				fi=new HDFSFile(newPath,size,new Date(),HDFSUtil.isDir(newPath),parentId);
			}else {
				fi=new HDFSFile(name,size,new Date(),HDFSUtil.isDir(newPath),parentId);
			}
			fileInfo.add(fi);
		}
		fs.close();
		return fileInfo;
		
	}
	public static void downloadFile(FileSystem fs,String path,String localPath) throws IOException {
		//打开数据流
		FSDataInputStream in=fs.open(new Path(path));
		//要下载的路径文件
		File file=new File(localPath);
		//重要
		FileOutputStream out=new FileOutputStream(new File(file,path.substring(path.lastIndexOf("/")+1)));
		IOUtils.copyBytes(in, out, 4096, true);
		in.close();
		out.close();
	}
	public static List<MapInfo> MapReduceResult(FileSystem fs,String path) throws IOException {
		//打开数据流
		FSDataInputStream in=fs.open(new Path(path));
		//这样就可以读取一行了
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String valueString=null;
		List<MapInfo> list=new ArrayList<>();
		while ((valueString=br.readLine())!=null){
		
			String []values=valueString.split("\\s+");
			String province=values[0];
			StringBuffer sb=new StringBuffer();
			for(int i=1;i<values.length;i++){
				sb.append(values[i]);
			}
			String value=sb.toString();
			String []values2=value.split("\\|");
			String foodName=values2[0];
			String hot=values2[1];
			MapInfo mapInfo=new MapInfo(ProvinceUtil.getChines(province), foodName, "", hot);
			list.add(mapInfo);
		}
		in.close();
		return list;
	}
	public static void downloadAllFile(FileSystem fs,String[] paths,String localPath) throws IOException {
		for (int i = 0; i < paths.length; i++) {
			String path=paths[i];
			FSDataInputStream in=fs.open(new Path(path));
			File file=new File(localPath);
			FileOutputStream out=new FileOutputStream(new File(file,path.substring(path.lastIndexOf("/")+2)));
			IOUtils.copyBytes(in, out, 4096, true);
			in.close();
			out.close();
		}
	}
	public static String read(FileSystem fs,String path) throws Exception {
		FSDataInputStream fdis =fs.open(new Path(path));
		byte[] b=new byte[fdis.available()];
		int tol=0;
//		fdis.read(tmp);
		fdis.read(b);
		//因为说utf-8编码通常前三个字节的值为-17 -69 -65
//		if (b[0]==-17 && b[1]==-69 && b[2]==-65) {}
//		if (b[0]>100) {
			return new String(b,"utf-8");
////		}
//		return new String(b,"gbk");
	}
	public static Boolean delete(FileSystem fs, Path path) throws IOException {
		boolean b=fs.deleteOnExit(path);
		fs.close();
		return b;
	}
	public static Boolean mkDir(FileSystem fs, Path path) throws IOException {
		boolean b=fs.mkdirs(path);
		fs.close();
		return b;
	}
	public static FileSystem setPro() throws IOException {
//		//设置用户名
//		System.setProperty("HADOOP_USER_NAME", "cherish");
//		//设置hadoop位置
//		System.setProperty("hadoop.home.dir", "F:\\centOs6.5文件\\hadoop-2.6.5");
		
		Configuration cf=new Configuration();
		FileSystem fs=FileSystem.get(cf);
		return fs;
	}
	public static boolean isDir(String path) throws IOException {
		FileSystem fs=HDFSUtil.setPro();
		boolean b=fs.isDirectory(new Path(path));
		return b;
	}
}
