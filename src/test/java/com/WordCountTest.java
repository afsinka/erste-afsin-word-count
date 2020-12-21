package com;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
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

  @Test
  public void testCountWordsWithRegexAndExclusionList() {
    List<String> excludedWords = new ArrayList<>();
    excludedWords.add("the");
    excludedWords.add("a");
    excludedWords.add("on");
    excludedWords.add("off");

    assertEquals(0, WordCount.countWordsWithRegex("", excludedWords));
    assertEquals(0, WordCount.countWordsWithRegex(" ", excludedWords));
    assertEquals(0, WordCount.countWordsWithRegex(null, excludedWords));
    assertEquals(4, WordCount.countWordsWithRegex("Marry had a little lamp", excludedWords));
    assertEquals(2, WordCount.countWordsWithRegex("all4you", excludedWords));
    assertEquals(3, WordCount.countWordsWithRegex("X.Y!Z", excludedWords));
    assertEquals(0, WordCount.countWordsWithRegex("the a on off", excludedWords));
  }
}
