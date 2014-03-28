package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private File originalFile;
	private File resultFile;
	
	public FileUtil(String originalFileName, String resultFileName) {
		super();
		//judge the os
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		StringBuilder pathname = new StringBuilder("file");
		StringBuilder pathnamenew = new StringBuilder("file");
		if(os.contains("Mac OS")) {
			pathname.append("//");
			pathnamenew.append("//");
		}else {
			pathname.append("\\");
			pathnamenew.append("\\");				
		}
		pathname.append(originalFileName);
		pathnamenew.append(resultFileName);
		originalFile = new File(pathname.toString());
		resultFile = new File(pathnamenew.toString());
	}
	
	public BufferedReader getBufferedReader() {
		try {
			return new BufferedReader(new FileReader(originalFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BufferedReader(null);
	}
	
	public BufferedWriter getBufferedWriter() {
		try {
			return new BufferedWriter(new FileWriter(resultFile,false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BufferedWriter(null);
	}	
}
