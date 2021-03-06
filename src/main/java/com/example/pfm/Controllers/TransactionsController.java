package com.example.pfm.Controllers;

import com.example.pfm.Helper.QueryParams;
import com.example.pfm.Models.TransactionEntity;
import com.example.pfm.Services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    //get all transactions
    @GetMapping("/transactions")
    public List<TransactionEntity> getTransactions(QueryParams queryParams) {
        return transactionsService.getTransactions(queryParams);
    }

    //import transaction
    @PostMapping("/transactions/import")
    public String importTransaction(@RequestBody InputStream transactions) {
        return transactionsService.importTransactions(transactions);
    }

    //get a transaction by id
    @GetMapping("/transactions/{id}")
    public TransactionEntity getTransaction(@PathVariable("id") Long id) {
        return transactionsService.getTransaction(id);
    }

    @GetMapping("/ok")
    public String ok() {
        return "ok";
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
