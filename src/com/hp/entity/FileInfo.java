package com.hp.entity;

public class FileInfo {
	private int FileId;
	private String name;
	private String type;
	private long size;
	
	public FileInfo() {}
	
	public FileInfo(String name, String type, long len) {
		super();
		this.name = name;
		this.type = type;
		this.size = len;
	}
	
	public FileInfo(int fileId, String name, String type, long size) {
		super();
		FileId = fileId;
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public int getFileId() {
		return FileId;
	}
	public void setFileId(int fileId) {
		FileId = fileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	
}
