package com.hp.dao.impl;
/**
 * 去掉文件的扩展名
 * @author 
 *
 */
public class FileName {
	public String getFileNameNoEx(String filename) { 
        if ((filename != null) && (filename.length() > 0)) { 
            int dot = filename.lastIndexOf('.'); 
            if ((dot >-1) && (dot < (filename.length()))) { 
                return filename.substring(0, dot); 
            } 
        } 
        return filename; 
    }
}
