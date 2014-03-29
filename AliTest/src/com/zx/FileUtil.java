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
import java.util.Properties;

public class FileUtil {	
	public static BufferedReader getBufferedReader(String fileName) {
		//judge the os
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		StringBuilder pathname = new StringBuilder("file");
		if(os.contains("Mac OS")) {
			pathname.append("//");
		}else {
			pathname.append("\\");				
		}
		pathname.append(fileName);
		File file = new File(pathname.toString());
		try {
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BufferedReader(null);
	}
	
	public static BufferedWriter getBufferedWriter(String fileName) {
		//judge the os
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		StringBuilder pathname = new StringBuilder("file");
		if(os.contains("Mac OS")) {
			pathname.append("//");
		}else {
			pathname.append("\\");				
		}
		pathname.append(fileName);
		File file = new File(pathname.toString());
		try {
			return new BufferedWriter(new FileWriter(file,false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BufferedWriter(null);
	}
	
	/** 
    * 复制单个文件 
    * @param oldPath String 原文件路径 
    * @param newPath String 复制后路径  
    * @return void
    */ 
	public static void copyFile(String oldFileName, String newFileName) { 
		//judge the os
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		StringBuilder path = new StringBuilder("file");
		StringBuilder newPath = new StringBuilder("file");
		if(os.contains("Mac OS")) {
			path.append("//");
			newPath.append("//");
		}else {
			path.append("\\");
			newPath.append("//");
		}
		path.append(oldFileName);
		newPath.append(newFileName);
		
		try { 
			int bytesum = 0; 
			int byteread = 0; 
			File oldfile = new File(path.toString()); 
			if (oldfile.exists()) {                  //文件存在时 
				InputStream inStream = new FileInputStream(path.toString());      //读入原文件 
				FileOutputStream fs = new FileOutputStream(newPath.toString(),false); 
				byte[] buffer = new byte[1444];  
				while ( (byteread = inStream.read(buffer)) != -1) { 
					bytesum += byteread;            //字节数 文件大小 
					System.out.println(bytesum);
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
