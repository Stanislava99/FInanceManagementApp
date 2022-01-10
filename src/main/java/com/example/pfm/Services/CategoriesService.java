package com.example.pfm.Services;

import com.example.pfm.Models.CategoryEntity;
import com.example.pfm.Models.TransactionEntity;
import com.example.pfm.Repos.CategoriesRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CategoriesService {

    public CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

   //import categrories from csv file
    public String importCategories(InputStream inputStream)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(",");
                categoriesRepository.save(new CategoryEntity(
                        lineArray[0],
                        lineArray[1],
                        lineArray[2]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    //get all categories
    public Iterable<CategoryEntity> getAllCategories() {
        return categoriesRepository.findAll();
    }


}
