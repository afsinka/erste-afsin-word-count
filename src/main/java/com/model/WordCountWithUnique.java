package com.model;

public class WordCountWithUnique {
  private long totalCount;
  private long uniqueCount;

  public WordCountWithUnique(long totalCount, long uniqueCount) {
    this.totalCount = totalCount;
    this.uniqueCount = uniqueCount;
  }

  public long getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }

  public long getUniqueCount() {
    return uniqueCount;
  }

  public void setUniqueCount(long uniqueCount) {
    this.uniqueCount = uniqueCount;
  }
}
