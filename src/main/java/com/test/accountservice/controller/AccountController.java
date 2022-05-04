package com.test.accountservice.controller;

import com.test.accountservice.model.AccountDto;
import com.test.accountservice.model.Method;
import com.test.accountservice.service.AccountService;
import com.test.accountservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final StatisticService statisticService;

    @GetMapping("/{id}")
    public Long getAmount(@PathVariable Integer id) {
        log.info("GET request id = {}", id);
        statisticService.increment(Method.GET);
        return accountService.getAmount(id);
    }

    @PostMapping
    public void addAmount(@RequestBody AccountDto accountDto) {
        log.info("ADD request id = {}, value = {}", accountDto.getId(), accountDto.getValue());
        statisticService.increment(Method.ADD);
        accountService.addAmount(accountDto.getId(), accountDto.getValue());
    }
}
