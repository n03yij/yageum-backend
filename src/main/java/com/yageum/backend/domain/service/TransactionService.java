package com.yageum.backend.domain.service;

import com.yageum.backend.domain.dto.TransactionRequestDto;
import com.yageum.backend.domain.entity.Transaction;
import com.yageum.backend.domain.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    // 전체 거래내역 조회
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 유저별 거래내역 조회
    public List<Transaction> getTransactionsByUserId(String userId) {
        return transactionRepository.findByUserId(userId);
    }

    // 거래내역 추가
    public Transaction createTransaction(TransactionRequestDto dto) {
        Transaction transaction = Transaction.builder()
                .id(UUID.randomUUID().toString())  // id 자동 생성
                .type(dto.getType())
                .category(dto.getCategory())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .merchant(dto.getMerchant())
                .memo(dto.getMemo())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }
}