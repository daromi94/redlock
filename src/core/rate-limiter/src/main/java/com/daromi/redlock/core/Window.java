package com.daromi.redlock.core;

import java.util.Objects;

public final class Window {

  private final Timestamp from;

  private final Timestamp to;

  private Window(final Timestamp from, final Timestamp to) {
    this.from = Objects.requireNonNull(from);
    this.to = Objects.requireNonNull(to);
  }

  public static Window of(final Timestamp from, final Timestamp to) {
    Objects.requireNonNull(from, "'from' must not be null");
    Objects.requireNonNull(to, "'to' must not be null");

    if (from.equals(to) || from.isAfter(to)) {
      throw new IllegalArgumentException("'from' must be strictly less than 'to'");
    }

    return new Window(from, to);
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof Window window)) {
      return false;
    }

    return this.from.equals(window.from) && this.to.equals(window.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}
