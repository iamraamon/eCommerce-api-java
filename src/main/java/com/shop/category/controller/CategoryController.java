package com.shop.category.controller;

import com.shop.category.entity.CategoryEntity;
import com.shop.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getCategoryList(){
        return categoryService.getCategory();
    }

    @PostMapping
    public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.saveCategory(categoryEntity);
    }

    @PutMapping
    public CategoryEntity updateCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.saveCategory(categoryEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "Deleted successfully";
    }
}
