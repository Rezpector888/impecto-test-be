package id.impecto.modules.category.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.impecto.modules.category.Category;
import id.impecto.modules.category.CategoryRepository;
import id.impecto.modules.category.dto.CreateCategoryDto;
import id.impecto.modules.category.services.CategoryService;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category create(CreateCategoryDto payload) {
        Category category = new Category();
        category.setName(payload.getName());
        return categoryRepository.save(category);
    }
}
