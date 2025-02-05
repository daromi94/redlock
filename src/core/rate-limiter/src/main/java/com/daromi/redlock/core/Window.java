package com.daromi.redlock.core;

public record Window(long from, long to) {

  public Window {
    if (from < 0 || to < 0) {
      throw new IllegalArgumentException("window bounds must be non-negative");
    }

    if (from >= to) {
      throw new IllegalArgumentException("'from' must be strictly less than 'to'");
    }
  }
}
