package com.daromi.redlock.core;

import java.util.List;

public interface RequestStore {

  List<Request> inWindow(long fromTimestamp, long toTimestamp);
}
