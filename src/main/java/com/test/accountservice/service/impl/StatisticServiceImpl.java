package com.test.accountservice.service.impl;

import com.test.accountservice.model.Method;
import com.test.accountservice.service.StatisticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Log4j2
@Service
public class StatisticServiceImpl implements StatisticService {

    private final Map<Method, AtomicLong> statisticMap = new ConcurrentHashMap<>(2, 0.75f, 2);
    private final long startTimeMillis = System.currentTimeMillis();

    public StatisticServiceImpl() {
        statisticMap.put(Method.ADD, new AtomicLong(0));
        statisticMap.put(Method.GET, new AtomicLong(0));
    }

    @Override
    public void increment(Method method) {
        statisticMap.get(method).incrementAndGet();
    }

    @Override
    public String get() {
        long secondsPassed = (System.currentTimeMillis() - startTimeMillis) / 1000;
        StringBuilder statistic = new StringBuilder();
        return statistic
                .append("ADD requests: ").append(statisticMap.get(Method.ADD)).append("\n")
                .append("GET requests: ").append(statisticMap.get(Method.GET)).append("\n")
                .append("ADD request per sec: ").append(statisticMap.get(Method.ADD).get() / (float) secondsPassed).append("\n")
                .append("GET request per sec: ").append(statisticMap.get(Method.GET).get() / (float) secondsPassed).toString();
    }

    @Override
    public void reset() {
        statisticMap.put(Method.ADD, new AtomicLong(0));
        statisticMap.put(Method.GET, new AtomicLong(0));
    }
}
