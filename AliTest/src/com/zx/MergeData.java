package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class MergeData {
	public static void main(String[] args) {
		FileUtil.copyFile("PeriodicityData.txt", "Result.txt");
		BufferedReader br = FileUtil.getBufferedReader("PeriodicityData.txt");
		BufferedReader br2 = FileUtil.getBufferedReader("RecentlyClickedData.txt");
		BufferedWriter bw = FileUtil.getBufferedWriter("Result3_29.txt");
		String line,line2;
		try {
			line = br.readLine();
			line2 = br2.readLine();
			
			StringTokenizer st = new StringTokenizer(line,"\t");
			StringTokenizer st2 = new StringTokenizer(line2, "\t");
			
			System.out.println(st.nextToken());
			System.out.println(st2.nextToken());
			System.out.println(st.nextToken());
			System.out.println(st2.nextToken());
			
			br.close();
			br2.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
