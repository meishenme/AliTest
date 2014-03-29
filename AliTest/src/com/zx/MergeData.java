package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class MergeData {
	public static void main(String[] args) {
		FileUtil.copyFile("RecentlyClickedData.txt", "Result3_29.txt");
		BufferedReader br = FileUtil.getBufferedReader("PeriodicityData.txt");
		BufferedWriter bw = FileUtil.getBufferedWriter("Result3_29.txt",true);
		
		try {
			String line = "";
			String customer = "", products = "";
			while( (line = br.readLine()) != null) {
				StringTokenizer stTab = new StringTokenizer(line,"\t");
				customer = stTab.nextToken();
				products = stTab.nextToken();
				
				StringTokenizer stProducts = new StringTokenizer(products, ",");
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
