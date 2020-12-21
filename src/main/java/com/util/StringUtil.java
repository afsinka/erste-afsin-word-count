package com.util;

import com.model.WordCountWithUnique;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections4.CollectionUtils;

public class StringUtil {

  private static final String REGEX = "([a-zA-Z]+)";

  /**
   * Returns count of words in a sentence
   */
  public static long countWordsWithRegex(final String text) {
    return countWordsWithRegex(text, Collections.emptyList());
  }

  /**
   * Returns count of words in a sentence except the ones in the exclusion list
   */
  public static long countWordsWithRegex(final String text, final List<String> excludedWords) {
    if (text == null || text.trim().isEmpty()) {
      return 0;
    }
    final Pattern pattern = Pattern.compile(REGEX);
    Matcher matcher = pattern.matcher(text);
    int count = 0;
    while (matcher.find()) {
      String word = matcher.group();
      if (CollectionUtils.isNotEmpty(excludedWords) && excludedWords.contains(word)) {
        //skip
      } else {
        count++;
      }
    }
    return count;
  }

  /**
   * Returns count of total words and unique words in a sentence except the ones in the exclusion list
   */
  public static WordCountWithUnique countUniqueWordsWithRegex(final String text, final List<String> excludedWords) {
    if (text == null || text.trim().isEmpty()) {
      return new WordCountWithUnique(0, 0);
    }

    List<String> countedWords = new ArrayList<>();

    final Pattern pattern = Pattern.compile(REGEX);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      String word = matcher.group();
      if (CollectionUtils.isNotEmpty(excludedWords) && excludedWords.contains(word)) {
        //skip
      } else {
        countedWords.add(word);
      }
    }

    Set<String> uniqueWords = new HashSet<>(countedWords);

    WordCountWithUnique result = new WordCountWithUnique(countedWords.size(), uniqueWords.size());

    return result;
  }
}
