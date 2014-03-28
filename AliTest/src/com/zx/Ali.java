package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Ali {
	public static void main(String[] args) {
		try {
			File csv = new File("C:\\Users\\Jim\\Desktop\\t_alibaba_data.csv");
			File csvNew = new File("C:\\Users\\Jim\\Desktop\\t_alibaba_data_1.txt");
			
			BufferedReader br = new BufferedReader(new FileReader(csv));
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvNew,false));
			
			br.readLine();//读表头
			
			String line = "";
			int column;
			
			while((line = br.readLine()) != null){
				
				column = 0;
				StringTokenizer st = new StringTokenizer(line, ",");
				
				while(st.hasMoreTokens()){
					column++;
					if(column == 4){
						StringTokenizer stmonth = new StringTokenizer(st.nextToken(), "月");
						StringBuilder date = new StringBuilder(stmonth.nextToken()+".");
	
						StringTokenizer stday = new StringTokenizer(stmonth.nextToken(),"日");
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
