package com.test.accountservice.service;

import com.test.accountservice.model.Method;

public interface StatisticService {
    void increment(Method method);
    String get();
    void reset();
}
