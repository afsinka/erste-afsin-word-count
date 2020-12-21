package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;

public class WordCount {

  private static String BASE_FILE_PATH = "src/main/resources/";
  private static String STOP_WORDS_FILE_PATH = "src/main/resources/stopwords.txt";

  public static void main(String[] args) {
    final List<String> excludedWords = readFile(STOP_WORDS_FILE_PATH);
    String input = null;

    if (args.length == 1) {
      final String fileName = args[0];
      List<String> wordsInFile = readFile(BASE_FILE_PATH + fileName);
      input = String.join(" ", wordsInFile);
    } else {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter text:");
      try {
        input = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    System.out.println("Number of words: " + countWordsWithRegex(input, excludedWords));
  }

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

  private static List<String> readFile(final String fileName) {
    List<String> list = new ArrayList<>();

    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      list = stream.collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return list;
  }
}
