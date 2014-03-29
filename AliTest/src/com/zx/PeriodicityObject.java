package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class PeriodicityObject {
	public static void main(String[] args) {
		String originalFileName = "t_alibaba_data_1.txt";
		String resultFileName = "PeriodicityData.txt";
		FileUtil fUtil = new FileUtil(originalFileName, resultFileName);
		BufferedReader br = fUtil.getBufferedReader();
		BufferedWriter bw = fUtil.getBufferedWriter();
		
		String lineTxt = "";
		String customer = "", customerCompare = "", customerFlag = "";
		String product = "", productCompare = "";
		String behavior = "";
		String date = "", month = "", monthCompare = "", day = "", dayCompare = "";
		int countBuy = 0, productCount = 0, customerCount = 0;
		
		try {
			while((lineTxt = br.readLine()) != null){
				
				StringTokenizer st = new StringTokenizer(lineTxt, ",");
			    customer = st.nextToken();
			    product = st.nextToken();
			    behavior = st.nextToken();
			    
			    date = st.nextToken();
			    StringTokenizer stDate = new StringTokenizer(date,".");
			    month = stDate.nextToken();
			    day = stDate.nextToken();
			    
			    if(customer.equals(customerCompare) && product.equals(productCompare)) {
			    	
			    	if(behavior.equals("1")) {
			    		if(!(month.equals(monthCompare) && day.equals(dayCompare))) {
			    			countBuy++;
			    			monthCompare = month;
			    			dayCompare = day;
			    		}
			    	}
			    }else {
			    	
			    	if(countBuy >= 2) {
			    		productCount++;
			    		
			    		if(!(customerFlag.equals(customerCompare))) {
			    			customerCount++;
			    			customerFlag= customerCompare;
			    			
			    			if(productCount != 1) {
			    				System.out.print("\n");
			    				bw.newLine();
			    			}
			    			System.out.print(customerCompare + "\t" + productCompare);
			    			bw.write(customerCompare + "\t" + productCompare);
			    		}else {
			    			System.out.print("," + productCompare);
			    			bw.write("," + productCompare);
			    		}
			    	}
			    	
			    	if(behavior.equals("1")) {
			    		countBuy = 1;
			    		monthCompare = month;
			    		dayCompare = day;
			    	}else {
			    		countBuy = 0;
			    		monthCompare = "";
			    		dayCompare = "";
			    	}
			    	
			    	customerCompare = customer;
			    	productCompare = product;
			    }
			}
			br.close();
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("\n");
		System.out.println("productCount:" + productCount);
		System.out.println("customerCount:" + customerCount);
	}
}
