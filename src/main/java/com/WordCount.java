package com;

import com.util.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    System.out.println("Number of words: " + StringUtil.countWordsWithRegex(input, excludedWords));
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
