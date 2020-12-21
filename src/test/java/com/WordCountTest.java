package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordCountTest {

  @Test
  public void testCountWordsWithRegex() {
    assertEquals(0, WordCount.countWordsWithRegex(""));
    assertEquals(0, WordCount.countWordsWithRegex(" "));
    assertEquals(0, WordCount.countWordsWithRegex(null));
    assertEquals(5, WordCount.countWordsWithRegex("Marry had a little lamp"));
    assertEquals(2, WordCount.countWordsWithRegex("all4you"));
    assertEquals(3, WordCount.countWordsWithRegex("X.Y!Z"));
  }
}
