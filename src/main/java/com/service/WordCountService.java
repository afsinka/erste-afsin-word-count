package com.service;

import com.dto.WordCountRequestDto;
import com.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class WordCountService {

  public Long count(WordCountRequestDto requestDto) {
    return StringUtil.countWordsWithRegex(requestDto.getText(), requestDto.getExcludedWords());
  }
}
