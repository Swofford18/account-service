package com.test.accountservice.service.impl;

import com.test.accountservice.model.TransactionEntity;
import com.test.accountservice.repository.TransactionRepository;
import com.test.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final TransactionRepository transactionRepository;

    @Override
    public Long getAmount(Integer id) {
        List<TransactionEntity> transactions = transactionRepository.findByAccountId(id);
        return transactions.isEmpty() ? 0 : transactions.stream()
                .map(TransactionEntity::getValue)
                .reduce(Long::sum)
                .orElse(0L);
    }

    @Override
    public void addAmount(Integer id, Long value) {
        transactionRepository.save(new TransactionEntity(id, value));
    }
}
