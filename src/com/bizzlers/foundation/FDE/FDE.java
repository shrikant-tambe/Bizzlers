package com.bizzlers.foundation.FDE;


//import java.util.Scanner;
import java.util.Vector;



public class FDE {

	/**
	 * @author Shrikant
	 * @ version 1.3
	 * 
	 * This is main class responsible for blinding all required classes  
	 * together. While deploying console based input should be removed 
	 * and replaced by input from text box
	 */
	

	/*
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		 
		 Vector<String> tokens = new Vector<String>();
		 Vector<String> keywords = new Vector<String>();
		  
		
		System.out.print("\n Enter Search Query : ");
		String query = s.nextLine();
		
		
		tokens = new Tokanizer().getTokens(query);
		
		Stopwords st = new Stopwords();
		
		
		System.out.println("Tokens :");
		
		for(int i=0 ;i < tokens.size() ; i++){
		System.out.println(tokens.get(i).toString());
		if(! st.is(tokens.get(i).toString())){
			keywords.add(tokens.get(i).toString());
		}
		}
		
		
		
		
		System.out.println("Keywords : ");
		
		for( int i=0 ;i < keywords.size() ; i++){
			System.out.println(keywords.get(i).toString());
			
		}
		
		System.out.println("\n After Stemming : ");
		
		Stemmer stemmer = new Stemmer();
		keywords= stemmer.stemming(keywords, keywords.size());
		
		for( int i=0 ;i < keywords.size() ; i++){
			System.out.println(keywords.get(i).toString());
			
		}
		
		
		
		keywords= new OrderKeywords().orderKeywords(keywords);
		
		System.out.println("\n After Shuffle: ");

		for( int i=0 ;i < keywords.size() ; i++){
			System.out.println(keywords.get(i).toString());
			
		}
		
		
		keywords=stemmer.removeDuplicateKeywords(keywords);
		
		
		System.out.println("\n After Duplicate Removal : ");

		for( int i=0 ;i < keywords.size() ; i++){
			System.out.println(keywords.get(i).toString());
			
		}
		
		
		new SearchKeywords().getSearchResults(keywords);
		
    
		//System.out.print("Size is : " + ThreadMain.getProcessMatchedSetInstance().getMoreMatched().size());
		
	}
	
*/	
	public Vector<ClassResultSet> search(String query){
	
		
		
		 Vector<String> tokens = new Vector<String>();
		 Vector<String> keywords = new Vector<String>();
		
		
		tokens = new Tokanizer().getTokens(query);		
		Stopwords st = new Stopwords();
		
		//Keywords
			
		for(int i=0 ;i < tokens.size() ; i++){

		if(! st.is(tokens.get(i).toString())){
			keywords.add(tokens.get(i).toString().toLowerCase());
		}
		}
		
		
		// After Stemming 
		Stemmer stemmer = new Stemmer();
		keywords=stemmer.stemming(keywords, keywords.size());
		
		// Shuffle
		keywords= new OrderKeywords().orderKeywords(keywords);
		
		
		// Duplicate Removal 
		keywords=stemmer.removeDuplicateKeywords(keywords);
		

		SearchKeywords searchKeywords = new SearchKeywords();
		searchKeywords.getSearchResults(keywords);
				
		Vector<ClassResultSet> resultSets =  searchKeywords.processMatchedSetInstance.getMoreMatched();
		Vector<ClassResultSet> newResultSet = new Vector<ClassResultSet>();
		
		//remove duplicates
		boolean isExist ;
		for(int i = 0 ; i < resultSets.size() ; i++ ){
			isExist = false ;
			for(int j= 0 ; i < newResultSet.size() ; j ++){
				if(resultSets.elementAt(i).getAllTogether().equals(newResultSet.elementAt(j).getAllTogether()))
					isExist = true ;
			}
			if(isExist == false)
				newResultSet.add(resultSets.elementAt(i));
		}
		
		return newResultSet;
	

	}
	
	
}