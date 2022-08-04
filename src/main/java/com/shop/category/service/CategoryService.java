package com.shop.category.service;

import com.shop.category.entity.CategoryEntity;
import com.shop.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategory(){
        return categoryRepository.findAll();
    }

    public CategoryEntity saveCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
