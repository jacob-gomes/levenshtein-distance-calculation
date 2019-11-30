package com.distance.calculator.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.distance.calculator.LevenshteinDistanceCalculator;

public class LevenshteinDistanceCalculatorImpl implements LevenshteinDistanceCalculator{

	@Override
	public int levenshtein(String token1, String token2) {
		int maxLength = 0;
		if(null != token1 && null != token2) {
			maxLength = Collections.max(Arrays.asList(token1.length(),token2.length()));
		}
		return levenshtein( token1,  token2, maxLength);
	}

	@Override
	public int levenshtein(String token1, String token2, int maxDist) {
		int lengthOfToken1;
		int lengthOfToken2;
		List<Integer> distances;
		
		if (token1 == token2) {
			return 0;
		}

		try {
			byte[] utf8Bytes;
			utf8Bytes = token1.getBytes("UTF-8");
			token1 = new String(utf8Bytes, "UTF-8");
			utf8Bytes = token2.getBytes("UTF-8");
			token2 = new String(utf8Bytes, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return 0;
		}
		
		lengthOfToken1 = token1.length();
		lengthOfToken2 = token2.length();
		
		if (Math.abs(lengthOfToken1 - lengthOfToken2) > maxDist) {
			return maxDist + 1;
		}
		if (lengthOfToken1 == 0) {
			return lengthOfToken2;
		}
		if (lengthOfToken2 == 0) {
			return lengthOfToken1;
		}
		
		
		if (lengthOfToken1 < lengthOfToken2) {
			int temporaryTokenLength = lengthOfToken1; 
			String temporaryString = token1;
			
			lengthOfToken1 = lengthOfToken2;
			lengthOfToken2 = temporaryTokenLength;
			token1 = token2;
			token2 = temporaryString;
		}
 
		distances = new ArrayList<>(lengthOfToken2 + 1);
		
		for (int indexForToken1 = 1; indexForToken1 <= lengthOfToken1; indexForToken1++) {

			int previousItterationDistanceValue = indexForToken1 - 1;
			int min = previousItterationDistanceValue;
			
			distances.add(0, indexForToken1);
			
			for (int indexForToken2 = 1; indexForToken2 <= lengthOfToken2; indexForToken2++) {
				int action = previousItterationDistanceValue;
				
				if(token1.charAt(indexForToken1-1) != token2.charAt(indexForToken2-1)) {
					action++;
				}
				
				previousItterationDistanceValue = distances.size() > indexForToken2 ? distances.get(indexForToken2) : 0;
				distances.add(indexForToken2 ,  Collections.min(Arrays.asList(
														1+previousItterationDistanceValue,
														1+distances.get(indexForToken2-1),
																action)));
				
				if (previousItterationDistanceValue < min) {
					min = previousItterationDistanceValue;
				}
			}
			if (min > maxDist) {
				return maxDist + 1;
			}
		}
		if (distances.get(lengthOfToken2) > maxDist) {
			return maxDist + 1;
		}
		
		return distances.get(lengthOfToken2);
	}

}
