package com.blank.transaction_analyzer.controller;

import com.blank.transaction_analyzer.model.Transaction;
import com.blank.transaction_analyzer.model.TransactionType;
import com.blank.transaction_analyzer.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import com.blank.transaction_analyzer.dto.MonthlySummaryDTO;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getTransactionsByType(@PathVariable TransactionType type) {
        return transactionService.getTransactionsByType(type);
    }

    @GetMapping("/summary")
    public MonthlySummaryDTO getMonthlySummary(
            @RequestParam int year,
            @RequestParam int month) {

        return transactionService.getMonthlySummary(year, month);
    }

    @GetMapping("/overall-summary")
    public MonthlySummaryDTO getOverallSummary() {
        return transactionService.getOverallSummary();
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}