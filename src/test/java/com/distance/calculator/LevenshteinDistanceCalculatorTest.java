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
	public void testLevenshtein() {
		assertEquals(1, levenshteinDistanceCalculator.levenshtein("Haus", "Maus"));
		assertEquals(2, levenshteinDistanceCalculator.levenshtein("Haus", "Mausi"));
		assertEquals(3, levenshteinDistanceCalculator.levenshtein("Haus", "Häuser"));
		assertEquals(12, levenshteinDistanceCalculator.levenshtein("Kartoffelsalat", "Runkelrüben") );
		
	}
	
}
