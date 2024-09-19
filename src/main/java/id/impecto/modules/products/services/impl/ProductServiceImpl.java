package id.impecto.modules.products.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.impecto.modules.category.Category;
import id.impecto.modules.category.CategoryRepository;
import id.impecto.modules.products.Product;
import id.impecto.modules.products.ProductRepository;
import id.impecto.modules.products.dto.CreateProductDto;
import id.impecto.modules.products.dto.UpdateProductDto;
import id.impecto.modules.products.services.ProductService;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Random;
@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product create(CreateProductDto payload) {
        Product product = new Product();
        Category category = categoryRepository.findById(payload.getCategoryId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found"));
        product.setName(payload.getName());
        product.setPrice(payload.getPrice());
        product.setCategory(category);
        if (payload.getCode() !=null) {
            Long countCode = productRepository.countByCodeStartingWith(payload.getCode());
            
            if (countCode != null && countCode > 0) {
                int incrementedCode = countCode.intValue() + 1;
                product.setCode(payload.getCode() + incrementedCode);
            } else {
                product.setCode(payload.getCode());
            }
        } else {
            // Jika kode kosong, buat kode acak
            Random random = new Random();
            int randomNumber = random.nextInt(10000); 
            String randomCode = String.format("%04d", randomNumber);
            product.setCode(randomCode);
        }
        
        return productRepository.save(product);
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
    }

    @Override
    @Transactional
    public Product update(Long id, UpdateProductDto payload) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
        if(payload.getName() != null) {
            product.setName(payload.getName());
        }
        if(payload.getPrice() != null) {
            product.setPrice(payload.getPrice());
        }
        if(payload.getCategoryId() != null) {
            Category category = categoryRepository.findById(payload.getCategoryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found"));
            product.setCategory(category);
        }
        if(payload.getCode() != null) {
            Long countCode = productRepository.countByCodeStartingWith(payload.getCode());
            
            if (countCode != null && countCode > 0) {
                int incrementedCode = countCode.intValue() + 1;
                product.setCode(payload.getCode() + incrementedCode);
            } else {
                product.setCode(payload.getCode());
            }
        }
        return productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found"));
        productRepository.delete(product);
        return product;
    }
}
