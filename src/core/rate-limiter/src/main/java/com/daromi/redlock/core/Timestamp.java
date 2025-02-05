package com.daromi.redlock.core;

import java.util.Objects;

public final class Timestamp {

  private final long value;

  private Timestamp(final long value) {
    this.value = value;
  }

  public static Timestamp from(final long value) {
    if (value < 0) {
      throw new IllegalArgumentException("value must be non-negative");
    }

    return new Timestamp(value);
  }

  public boolean isAfter(final Timestamp other) {
    Objects.requireNonNull(other, "other must not be null");

    return this.value > other.value;
  }

  public boolean isBefore(final Timestamp other) {
    Objects.requireNonNull(other, "other must not be null");

    return this.value < other.value;
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof Timestamp timestamp)) {
      return false;
    }

    return this.value == timestamp.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
