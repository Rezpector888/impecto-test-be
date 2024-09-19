package id.impecto.modules.category;

import org.springframework.web.bind.annotation.RestController;

import id.impecto.modules.category.dto.CreateCategoryDto;
import id.impecto.modules.category.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category")
public class CategoryController {
    
    
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto payload) {
        Category category = categoryService.create(payload);
        return new ResponseEntity<>(category, HttpStatus.OK);
        
    }
    
    
}
