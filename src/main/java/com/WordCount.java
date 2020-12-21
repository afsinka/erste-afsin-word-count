package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter text:");
    try {
      String input = br.readLine();
      System.out.println("Number of words:  " + countWordsWithRegex(input));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns count of words in a sentence
   */
  public static long countWordsWithRegex(final String text) {
    if (text == null || text.trim().isEmpty()) {
      return 0;
    }
    final Pattern pattern = Pattern.compile("([a-zA-Z-]+)");
    Matcher matcher = pattern.matcher(text);
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    return count;
  }
}
