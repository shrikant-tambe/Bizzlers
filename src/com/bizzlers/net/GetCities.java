package com.bizzlers.net;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GetCities {
	 private int totaldata;
	 
	 private String data = "Mumbai, Thane, Raigad, Ratnagiri, Sindhudurg, Pune, Satara, Sangli, Solapur, Kolhapur, Nashik, Dhule, Jalgaon, Ahmednagar,  Nandurbar,Aurangabad, Jalna, Latur, Nanded, Osmanabad, Parbhani, Hingoli, Beed, Nagpur, Chandrapur, Wardha, Bhandara, Gondia, Gadchiroli, Amravati, Akola, Washim, Buldhana,Yavatmal";
	    private List<String> list;
	    public GetCities() {
	    	 list = new ArrayList<String>();
	    	 StringTokenizer st = new StringTokenizer(data, ",");
	    	 
		        while(st.hasMoreTokens()) {
		            list.add(st.nextToken().trim());
		        }
		        totaldata = list.size();
	    	 
	    }
	    public List<String> getData(String query) {
	        String country = null;
	        query = query.toLowerCase();
	        List<String> matched = new ArrayList<String>();
	        for(int i=0; i<totaldata; i++) {
	            country = list.get(i).toLowerCase();
	            if(country.startsWith(query)) {
	                matched.add(list.get(i));
	            }
	        }
	        return matched;
	    }
}
