package com.distance.calculator;

public interface LevenshteinDistanceCalculator {
	int levenshtein(String token1, String token2);
	
	int levenshtein(String token1, String token2, int maxDist);
}
