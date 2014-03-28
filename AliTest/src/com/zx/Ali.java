package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.StringTokenizer;

public class Ali {
	public static void main(String[] args) {
		try {
			//judge the os
			Properties prop = System.getProperties();
			String os = prop.getProperty("os.name");
			String pathname,pathnamenew;
			if(os.contains("Mac OS")) {
				pathname = "file//t_alibaba_data.csv";
				pathnamenew = "file//t_alibaba_data_1.txt";
			}else {
				pathname = "file\\t_alibaba_data.csv";
				pathnamenew = "file\\t_alibaba_data_1.txt";				
			}
			File csv = new File(pathname);
			File csvNew = new File(pathnamenew);
			
			BufferedReader br = new BufferedReader(new FileReader(csv));
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvNew,false));
			
			br.readLine();// read head of the file
			
			String line = "";
			int column;
			
			while((line = br.readLine()) != null){
				
				column = 0;
				StringTokenizer st = new StringTokenizer(line, ",");
				
				while(st.hasMoreTokens()){
					column++;
					if(column == 4){
						StringTokenizer stmonth = new StringTokenizer(st.nextToken(), 
								new String("月".getBytes("UTF-8"), "GBK"));
						StringBuilder date = new StringBuilder(stmonth.nextToken()+".");
	
						StringTokenizer stday = new StringTokenizer(stmonth.nextToken(),
								new String("日".getBytes("UTF-8"), "GBK"));
						date.append(stday.nextToken());
						System.out.print(date);
						
						bw.write(date.toString());
						
					}else{
						String newline = st.nextToken();
						System.out.print(newline + "\t");
						
						bw.write(newline + ",");
					}
				}
				System.out.println();
				bw.newLine();
			}
			bw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
