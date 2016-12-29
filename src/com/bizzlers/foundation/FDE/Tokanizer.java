package com.bizzlers.foundation.FDE;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 
 * @author Shrikant
 * @version 1.0
 *
 * This class processes search string and produce number of token
 * Each token is separate string
 */
public class Tokanizer 
{
	
	/**
	 * This method tokenize the string
	 * @param query
	 * @return Vector containing tokens
	 * 
	 */
    public Vector<String> getTokens( String query )
    {
    	 Vector<String>   tokens = new Vector<String>();
    	 
    	 query= query.replace(',',' ');
    	
    	StringTokenizer st = new StringTokenizer(query);
    
    	while(st.hasMoreElements()){
    		tokens.add(st.nextElement().toString());	
    	}
    	
    	return tokens; 
    }
    
}
