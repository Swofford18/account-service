package com.test.accountservice.controller;

import com.test.accountservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping
    public Object get() {
        return statisticService.get();
    }

    @DeleteMapping("/reset")
    public void reset() {
        statisticService.reset();
    }
}
