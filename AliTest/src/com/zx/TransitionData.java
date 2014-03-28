package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class TransitionData {
	public static void main(String[] args) {
		try {
			String originalFileName = "t_alibaba_data.csv";
			String resultFileName = "t_alibaba_data_1.txt";
			FileUtil fUtil = new FileUtil(originalFileName, resultFileName);
			BufferedReader br = fUtil.getBufferedReader();
			BufferedWriter bw = fUtil.getBufferedWriter();
			
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
