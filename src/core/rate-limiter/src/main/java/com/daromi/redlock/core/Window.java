package com.daromi.redlock.core;

import java.util.Objects;

public final class Window {

  private final long from;

  private final long to;

  private Window(final long from, final long to) {
    this.from = from;
    this.to = to;
  }

  public static Window of(final long from, final long to) {
    if (from < 0 || to < 0) {
      throw new IllegalArgumentException("window bounds must be non-negative");
    }

    if (from >= to) {
      throw new IllegalArgumentException("'from' must be strictly less than 'to'");
    }

    return new Window(from, to);
  }

  public long getFrom() {
    return from;
  }

  public long getTo() {
    return to;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof Window window)) {
      return false;
    }

    return this.from == window.from && this.to == window.to;
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}
