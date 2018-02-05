package com.hp.entity;

import java.util.Date;

public class HDFSFile {
	private Integer fileId=0;
	private String fileName;
	private float  size;
	private Date  uploadtime;
	private Integer parentId;
	private boolean isDir;
	
	public HDFSFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HDFSFile(String fileName, float size, Date uploadtime, Integer parentId, boolean isDir) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.parentId = parentId;
		this.isDir = isDir;
	}

	public HDFSFile(String fileName, float size, Date uploadtime) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
	}

	public HDFSFile(String fileName, float size, Date uploadtime, Integer parentId) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.parentId = parentId;
	}

	public HDFSFile(String fileName, float size, Date uploadtime, boolean isDir, Integer parentId) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.parentId = parentId;
		this.isDir = isDir;
	}

	public HDFSFile(Integer fileId, String fileName, float size, Date uploadtime, Integer parentId) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.parentId = parentId;
	}

	public HDFSFile(String fileName, float size, Date uploadtime, boolean isDir) {
		super();
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.isDir = isDir;
	}
	
	public HDFSFile(Integer fileId, String fileName, float size, Date uploadtime, Integer parentId, boolean isDir) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.size = size;
		this.uploadtime = uploadtime;
		this.parentId = parentId;
		this.isDir = isDir;
	}

	public boolean isDir() {
		return isDir;
	}

	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	
}
