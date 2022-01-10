package com.example.pfm.Controllers;

import com.example.pfm.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class CategoriesController {

    private CategoriesService categoriesService;


    //import categories
    public String importCategories(InputStream inputStream) {
        categoriesService.importCategories(inputStream);
    }

    //get categories

}
