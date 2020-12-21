package com;

import static org.junit.Assert.assertEquals;

import com.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class StringUtilTest {

  @Test
  public void testCountWordsWithRegex() {
    assertEquals(0, StringUtil.countWordsWithRegex(""));
    assertEquals(0, StringUtil.countWordsWithRegex(" "));
    assertEquals(0, StringUtil.countWordsWithRegex(null));
    assertEquals(5, StringUtil.countWordsWithRegex("Marry had a little lamp"));
    assertEquals(2, StringUtil.countWordsWithRegex("all4you"));
    assertEquals(3, StringUtil.countWordsWithRegex("X.Y!Z"));
  }

  @Test
  public void testCountWordsWithRegexAndExclusionList() {
    List<String> excludedWords = new ArrayList<>();
    excludedWords.add("the");
    excludedWords.add("a");
    excludedWords.add("on");
    excludedWords.add("off");

    assertEquals(0, StringUtil.countWordsWithRegex("", excludedWords));
    assertEquals(0, StringUtil.countWordsWithRegex(" ", excludedWords));
    assertEquals(0, StringUtil.countWordsWithRegex(null, excludedWords));
    assertEquals(4, StringUtil.countWordsWithRegex("Marry had a little lamp", excludedWords));
    assertEquals(2, StringUtil.countWordsWithRegex("all4you", excludedWords));
    assertEquals(3, StringUtil.countWordsWithRegex("X.Y!Z", excludedWords));
    assertEquals(0, StringUtil.countWordsWithRegex("the a on off", excludedWords));
  }

  @Test
  public void testCountUniqueWordsWithRegex() {
    List<String> excludedWords = new ArrayList<>();
    excludedWords.add("the");
    excludedWords.add("a");
    excludedWords.add("on");
    excludedWords.add("off");

    assertEquals(9, StringUtil.countUniqueWordsWithRegex("Humpy-Dumpy sat on a wall. Humpy-Dumpy had a great fall ",
        excludedWords).getTotalCount());
    assertEquals(7, StringUtil.countUniqueWordsWithRegex("Humpy-Dumpy sat on a wall. Humpy-Dumpy had a great fall ",
        excludedWords).getUniqueCount());

  }
}
