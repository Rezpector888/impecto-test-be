package id.impecto.modules.category.services;
import java.util.List;

import id.impecto.modules.category.Category;
import id.impecto.modules.category.dto.CreateCategoryDto;

public interface CategoryService {
    List<Category> findAll();

    Category create(CreateCategoryDto payload);
    
}
