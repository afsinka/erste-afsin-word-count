package com.util;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections4.CollectionUtils;

public class StringUtil {

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
    final Pattern pattern = Pattern.compile("([a-zA-Z-]+)");
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
}
