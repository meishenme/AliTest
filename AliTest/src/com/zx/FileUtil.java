package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

public class FileUtil {	
	public static String getPathPrefix() {
		//judge the os
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		StringBuilder pathname = new StringBuilder("file");
		if(os.contains("Mac OS")) {
			pathname.append("//");
		}else {
			pathname.append("\\");				
		}
		return pathname.toString();
	}
	public static BufferedReader getBufferedReader(String fileName) {
		StringBuilder pathname = new StringBuilder(getPathPrefix());
		pathname.append(fileName);
		File file = new File(pathname.toString());
		try {
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedWriter getBufferedWriter(String fileName, boolean append) {
		StringBuilder pathname = new StringBuilder(getPathPrefix());
		pathname.append(fileName);
		File file = new File(pathname.toString());
		try {
			return new BufferedWriter(new FileWriter(file,append));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static RandomAccessFile getRandomAccessFile(String fileName) {
		StringBuilder pathname = new StringBuilder(getPathPrefix());
		pathname.append(fileName);
		try {
			return new RandomAccessFile(pathname.toString(), "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/** 
    * 复制单个文件 
    * @param oldPath String 原文件路径 
    * @param newPath String 复制后路径  
    * @return void
    */ 
	public static void copyFile(String oldFileName, String newFileName) { 
		StringBuilder path = new StringBuilder(getPathPrefix());
		StringBuilder newPath = new StringBuilder(getPathPrefix());
		path.append(oldFileName);
		newPath.append(newFileName);
		
		try {
			int byteread = 0; 
			File oldfile = new File(path.toString()); 
			if (oldfile.exists()) {                  //文件存在时 
				InputStream inStream = new FileInputStream(path.toString());      //读入原文件 
				FileOutputStream fs = new FileOutputStream(newPath.toString(),false); 
				byte[] buffer = new byte[1444];  
				while ( (byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			} 
		}catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
}
