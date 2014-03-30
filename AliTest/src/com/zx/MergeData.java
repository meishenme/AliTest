package com.zx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class MergeData {
	public static void main(String[] args) {
		FileUtil.copyFile("RecentlyClickedData.txt", "Result3_30.txt");
		BufferedReader br = FileUtil.getBufferedReader("PeriodicityData.txt");
		RandomAccessFile rf = FileUtil.getRandomAccessFile("Result3_30.txt");
		
		try {
			String line = "";
			String customer = "", products = "";
			String lineResult = "";
			String customerResult = "", productsResult = "";
			long countLine;
			
			if( (line = br.readLine()) != null) {
				line = br.readLine();
				StringTokenizer stTab = new StringTokenizer(line,"\t");
				customer = stTab.nextToken();
				products = stTab.nextToken();
				
				while(rf.getFilePointer() < rf.length()) {
					lineResult = rf.readLine();
					StringTokenizer stResultTab = new StringTokenizer(lineResult,"\t");
					customerResult = stResultTab.nextToken();
					productsResult = stResultTab.nextToken();
					
					countLine = lineResult.toCharArray().length;
					
					if(customer.equals(customerResult)) {
						System.out.println(rf.getFilePointer());
						System.out.println(countLine);
						System.out.println(productsResult);
						System.out.println(products);
						rf.seek(rf.getFilePointer() - countLine - 1);
						rf.skipBytes((int)countLine);
						
						rf.seek(0);
						break;
					}else {
						if(rf.getFilePointer() == rf.length()) {
							rf.writeChars(line);
							
							rf.seek(0);
							break;
						}
					}
				}
			}
			br.close();
			rf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
