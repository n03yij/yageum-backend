package com.yageum.backend.domain.controller;

import com.yageum.backend.domain.dto.TransactionRequestDto;
import com.yageum.backend.domain.entity.Transaction;
import com.yageum.backend.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    // 전체 거래내역 조회
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    // 유저별 거래내역 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(transactionService.getTransactionsByUserId(userId));
    }

    // 거래내역 추가
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequestDto dto) {
        return ResponseEntity.ok(transactionService.createTransaction(dto));
    }

    // 거래내역 수정
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable String id, @RequestBody TransactionRequestDto dto) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, dto));
    }

    // 거래내역 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable String id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}