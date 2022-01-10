package com.example.pfm.Controllers;

import com.example.pfm.Models.CategoryEntity;
import com.example.pfm.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {

    private CategoriesService categoriesService;


    //import categories
    @PostMapping("/categories/import")
    public String importCategories(InputStream inputStream) {
        return categoriesService.importCategories(inputStream);
    }

    //get categories
    @GetMapping("/categiries")
    public Iterable<CategoryEntity> getCategories() {
        return categoriesService.getAllCategories();
    }

}
