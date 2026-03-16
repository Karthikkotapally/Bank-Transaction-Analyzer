package com.blank.transaction_analyzer.service;

import com.blank.transaction_analyzer.model.Transaction;
import com.blank.transaction_analyzer.model.TransactionType;
import com.blank.transaction_analyzer.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.blank.transaction_analyzer.dto.MonthlySummaryDTO;

import java.time.Month;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByType(TransactionType type) {

        List<Transaction> allTransactions = transactionRepository.findAll();

        return allTransactions.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }

    public MonthlySummaryDTO getMonthlySummary(int year, int month) {

        List<Transaction> transactions = transactionRepository.findAll();

        double totalDebit = transactions.stream()
                .filter(t -> t.getDate().getYear() == year)
                .filter(t -> t.getDate().getMonthValue() == month)
                .filter(t -> t.getType() == TransactionType.DEBIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalCredit = transactions.stream()
                .filter(t -> t.getDate().getYear() == year)
                .filter(t -> t.getDate().getMonthValue() == month)
                .filter(t -> t.getType() == TransactionType.CREDIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        return new MonthlySummaryDTO(totalDebit, totalCredit);
    }

    public MonthlySummaryDTO getOverallSummary() {

        List<Transaction> transactions = transactionRepository.findAll();

        double totalDebit = transactions.stream()
                .filter(t -> t.getType() == TransactionType.DEBIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalCredit = transactions.stream()
                .filter(t -> t.getType() == TransactionType.CREDIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        return new MonthlySummaryDTO(totalDebit, totalCredit);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
