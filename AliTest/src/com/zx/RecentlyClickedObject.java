package com.zx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class RecentlyClickedObject {
	public static void main(String[] args) {
		BufferedReader br = FileUtil.getBufferedReader("t_alibaba_data_1.txt");
		BufferedWriter bw = FileUtil.getBufferedWriter("2222222222.txt",false);
		
		String lineTxt = "";
		String customer = "", customerCompare = "", customerFlag = "";
		String product = "", productCompare = "";
		String behavior = "";
		String date = "", month = "",day = "";
		int countClicked = 0, productCount = 0, customerCount = 0;
		boolean isBought = false;
		//---------------------------
		boolean behavior2Or3 = false;
		boolean month5678 = false;
		//---------------------------
		
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
			    //Test
			    if(month.compareTo("5") > 0 || ((month.compareTo("5") == 0) && (day.compareTo("15") >= 0))) {
			    	month5678 = true;
			    	continue;
			    }
			    	
			    if(behavior.equals("1"))
			    	isBought = true;
                //---------------------------
//			    if(month.compareTo("7") < 0)
//            		continue;
//            	else {
//            		if(behavior.equals("2") || behavior.equals("3")) {
//            			behavior2Or3 = true;
//            		}
//            		if(behavior.equals("1"))
//            			isBought = true;
//				}
			    //---------------------------
//			    if(month.compareTo("7") < 0)
//                	continue;
//                else {
//                	if(behavior.equals("1")) {
//                		isBought = true;
//                	}
//              }
			    
			    if(customer.equals(customerCompare) && product.equals(productCompare)) {
			    	countClicked++;
			    }else {
			    	
//			    	if(behavior2Or3 == true && isBought == false) {
//			    	if(countClicked >= 6) {
			    	if(countClicked >= 15 && isBought == false && month5678 == false) {
			    		
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
			    	
//			    	if(behavior.equals("2") || behavior.equals("3")) {
//            			behavior2Or3 = true;
//			    	}else {
//			    		behavior2Or3 = false;
//			    	}
			    	
			    	if(behavior.equals("1"))
			    		isBought = true;
			    	else
			    		isBought = false;
			    	
			    	customerCompare = customer;
			    	productCompare = product;
			    	countClicked = 1;
			    	month5678 = false;
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
