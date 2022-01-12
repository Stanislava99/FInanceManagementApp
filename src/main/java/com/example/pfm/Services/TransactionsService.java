package com.example.pfm.Services;

import com.example.pfm.Helper.QueryParams;
import com.example.pfm.Models.TransactionEntity;
import com.example.pfm.Repos.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Collections.reverseOrder;

@Component
public class TransactionsService {

    @Autowired
    public TransactionsRepository transactionsRepository;

//    public TransactionsService(TransactionsRepository transactionsRepository) {
//        this.transactionsRepository = transactionsRepository;
//    }

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
                       lineArray[3],
                       Double.parseDouble(lineArray[4]),
                       lineArray[5],
                       lineArray[6],
                       Long.parseLong(lineArray[7]),
                       lineArray[8]
               ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    //get all transactions
    public List<TransactionEntity> getTransactions(QueryParams queryParams) {

        List<TransactionEntity> transactions = transactionsRepository.findAll();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int numberOfPages = (int) Math.ceil(transactions.size() / queryParams.getPageSize());

        if (queryParams.getStartDate() != null) {
            transactions.removeIf(transaction -> {
                try {
                    return dateFormat.parse(transaction.getDate()).after(dateFormat.parse(queryParams.getStartDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false;
                }
            });
        }

        if (queryParams.getEndDate() != null) {
            transactions.removeIf(transaction -> {
                try {
                    return dateFormat.parse(transaction.getDate()).after(dateFormat.parse(queryParams.getEndDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return false;
                }
            });
        }

        if (queryParams.getTransactionKind() != null) {
            transactions.removeIf(transaction -> transaction.getKind().compareTo(queryParams.getTransactionKind()) != 0);
        }

        for (int i=0;i<queryParams.getPageSize();i++) {
            int ind = (queryParams.getPage() - 1 ) * 10;

        }

        if (Objects.equals(queryParams.getSortOrder(), "ASC")) {
            //sort by id ascending
            transactions.sort(Comparator.comparing(TransactionEntity::getId));
        }
        else if(queryParams.getSortOrder().equals("DESC")) {
            Collections.sort(transactions,reverseOrder());
        }


        return transactions;
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
