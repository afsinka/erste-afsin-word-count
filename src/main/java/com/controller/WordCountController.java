package com.controller;

import com.dto.WordCountRequestDto;
import com.service.WordCountService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCountController {

  @Autowired
  private WordCountService wordCountService;

  @PostMapping("/count")
  public Long count(@Valid @RequestBody WordCountRequestDto requestDto) {
    return wordCountService.count(requestDto);
  }


}