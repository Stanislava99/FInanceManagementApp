package com.example.pfm.Services;

import com.example.pfm.Models.TransactionEntity;
import com.example.pfm.Repos.TransactionsRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TransactionsService {

    public TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    //import transactions from csv file
    public String importTransactions(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(",");
               transactionsRepository.save(new TransactionEntity(
                     Long.parseLong(lineArray[0]),
                     lineArray[1],
                     lineArray[2],
                       Double.parseDouble(lineArray[3]),
                       lineArray[4],
                       lineArray[5],
                       lineArray[6],
                       lineArray[7]
               ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    //get all transactions
    public Iterable<TransactionEntity> getTransactions() {
        return transactionsRepository.findAll();
    }

    //get transaction by id
    public TransactionEntity getTransaction(Long id) {
        if (transactionsRepository.findById(id).isPresent()) {
            return transactionsRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    //split transaction

    //categorize transaction




}
