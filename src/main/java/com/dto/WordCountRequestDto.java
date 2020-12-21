package com.dto;

import java.util.List;
import javax.validation.constraints.NotEmpty;

public class WordCountRequestDto {
  @NotEmpty(message = "Text must not be empty")
  private String text;

  private List<String> excludedWords;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<String> getExcludedWords() {
    return excludedWords;
  }

  public void setExcludedWords(List<String> excludedWords) {
    this.excludedWords = excludedWords;
  }
}
