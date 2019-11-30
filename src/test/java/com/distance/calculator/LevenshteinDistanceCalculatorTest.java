package com.distance.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.distance.calculator.impl.LevenshteinDistanceCalculatorImpl;

public class LevenshteinDistanceCalculatorTest {
	
	private LevenshteinDistanceCalculator levenshteinDistanceCalculator;
	
	@Before
	public void init() {
		levenshteinDistanceCalculator = new LevenshteinDistanceCalculatorImpl();
	}
	
	@Test
	public void testLevenshteinForIdenticalString() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Haus",0);
		
		System.out.println("Miliseconds to execute testLevenshteinForIdenticalString(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinForSingleSubstitution() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Maus",1);
		
		System.out.println("Miliseconds to execute testLevenshteinForSingleSubstitution(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinForSingleSubstitutionAndDeletion() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Mausi",2);
		
		System.out.println("Miliseconds to execute testLevenshteinForSingleSubstitutionAndDeletion(): "+ timeTaken);
	}

	
	@Test
	public void testLevenshteinForMultipleSubstitutionAndDeletion() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Häuser",3);
		
		System.out.println("Miliseconds to execute testLevenshteinForMultipleSubstitutionAndDeletion(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinForAllCombination() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Kartoffelsalat", "Runkelrüben",12);
		
		System.out.println("Miliseconds to execute testLevenshteinForAllCombination(): "+ timeTaken);
	}
	
	/**
	 * ===================
	 */
	

	@Test
	public void testLevenshteinWithMaxValueForIdenticalString() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Haus", 2,0);
		
		System.out.println("Miliseconds to execute testLevenshteinWithMaxValueForIdenticalString(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinWithMaxValueForSingleSubstitution() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Maus", 2, 1);
		
		System.out.println("Miliseconds to execute testLevenshteinWithMaxValueForSingleSubstitution(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinWithMaxValueForSingleSubstitutionAndDeletion() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Mausi", 2, 2);
		
		System.out.println("Miliseconds to execute testLevenshteinWithMaxValueForSingleSubstitutionAndDeletion(): "+ timeTaken);
	}

	
	@Test
	public void testLevenshteinWithMaxValueForMultipleSubstitutionAndDeletion() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Haus", "Häuser", 2, 3);
		
		System.out.println("Miliseconds to execute testLevenshteinWithMaxValueForMultipleSubstitutionAndDeletion(): "+ timeTaken);
	}
	
	@Test
	public void testLevenshteinWithMaxValueForAllCombination() {
		
		Long timeTaken = commonTestRunnerForLevenshtein("Kartoffelsalat", "Runkelrüben", 2, 3);
		
		System.out.println("Miliseconds to execute testLevenshteinWithMaxValueForAllCombination(): "+ timeTaken);
	}
	
	
	
	private Long commonTestRunnerForLevenshtein(String token1, String token2, Integer expectedValue) {
		Long timeTaken = System.currentTimeMillis();
		Integer levenshteinDistance = levenshteinDistanceCalculator.levenshtein(token1, token2);
		timeTaken = System.currentTimeMillis() - timeTaken ;	
		
		assertEquals(expectedValue, levenshteinDistance);
		
		return timeTaken;
		
	}
	
	
	private Long commonTestRunnerForLevenshtein(String token1, String token2, Integer maxValue, Integer expectedValue) {
		Long timeTaken = System.currentTimeMillis();
		Integer levenshteinDistance = levenshteinDistanceCalculator.levenshtein(token1, token2, maxValue);
		timeTaken = System.currentTimeMillis() - timeTaken ;	
		
		assertEquals(expectedValue, levenshteinDistance);
		
		return timeTaken;
		
	}
	
}
