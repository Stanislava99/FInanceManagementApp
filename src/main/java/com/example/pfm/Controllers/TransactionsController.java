package com.example.pfm.Controllers;

import com.example.pfm.Helper.QueryParams;
import com.example.pfm.Models.TransactionEntity;
import com.example.pfm.Services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class TransactionsController {

    private TransactionsService transactionsService;

    //get all transactions
    @GetMapping("/transactions")
    public Iterable<TransactionEntity> getTransactions() {
        return transactionsService.getTransactions();
    }

    //import transaction
    @PostMapping("/transactions/import")
    public String importTransaction(@RequestBody InputStream transactions) {
        return transactionsService.importTransactions(transactions);
    }

    //get a transaction
    @GetMapping("/transactions/{id}")
    public TransactionEntity getTransaction(@PathVariable("id") Long id) {
        return transactionsService.getTransaction(id);
    }

    //split transaction
//    @PostMapping("/transactions/{id}/split")
//    public String splitTransaction(@PathVariable("id") String id, @RequestBody String transactions) {
//        return transactionsService.splitTransaction(id, transactions);
//    }

    //categorize transaction
//    @PostMapping("/transactions/{id}/categorize")
//    public String categorizeTransaction(@PathVariable("id") Long id, @RequestBody String category) {
//        return transactionsService.categorizeTransaction(id, category);
//    }


}
