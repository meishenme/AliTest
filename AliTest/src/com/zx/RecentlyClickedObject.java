package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class RecentlyClickedObject {
	public static void main(String[] args) {
		BufferedReader br = FileUtil.getBufferedReader("t_alibaba_data_1.txt");
		BufferedWriter bw = FileUtil.getBufferedWriter("RecentlyClickedData.txt",false);
		
		String lineTxt = "";
		String customer = "", customerCompare = "", customerFlag = "";
		String product = "", productCompare = "";
		String behavior = "";
		String date = "", month = "";
		int countClicked = 0, productCount = 0, customerCount = 0;
		boolean isBought = false;
		
		try {
			while((lineTxt = br.readLine()) != null){
				
				StringTokenizer st = new StringTokenizer(lineTxt, ",");
			    customer = st.nextToken();
			    product = st.nextToken();
			    behavior = st.nextToken();
			    
			    date = st.nextToken();
			    StringTokenizer stDate = new StringTokenizer(date,".");
			    month = stDate.nextToken();
                
			    if(month.compareTo("7") < 0)
                	continue;
                else {
                	if(behavior.equals("1")) {
                		isBought = true;
                	}
                }
			    
			    if(customer.equals(customerCompare) && product.equals(productCompare)) {
			    	countClicked++;
			    }else {
			    	
			    	if(countClicked >= 4 && isBought == false) {
			    		productCount++;
			    		
			    		//------------------------------------------
			    		if(productCount != 1) {
			    			System.out.print("\n");
			    			bw.newLine();
			    		}
			    		System.out.print(customerCompare + "\t" + productCompare);
			    		bw.write(customerCompare + "\t" + productCompare);
			    		//------------------------------------------
			    		
//			    		if(!(customerFlag.equals(customerCompare))) {
//			    			customerCount++;
//			    			customerFlag= customerCompare;
//			    			
//			    			if(productCount != 1) {
//			    				System.out.print("\n");
//			    				bw.newLine();
//			    			}
//			    			System.out.print(customerCompare + "\t" + productCompare);
//			    			bw.write(customerCompare + "\t" + productCompare);
//			    		}else {
//			    			System.out.print("," + productCompare);
//			    			bw.write("," + productCompare);
//			    		}
			    	}
			    	
			    	if(behavior.equals("1")) {
			    		isBought = true;
			    	}else {
			    		isBought = false;
			    	}
			    	
			    	customerCompare = customer;
			    	productCompare = product;
			    	countClicked = 1;
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
