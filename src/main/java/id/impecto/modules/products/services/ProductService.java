package id.impecto.modules.products.services;


import java.util.List;

import id.impecto.modules.products.Product;
import id.impecto.modules.products.dto.CreateProductDto;
import id.impecto.modules.products.dto.UpdateProductDto;;
public interface ProductService {
    List<Product> findAll();
    Product findOne(Long id);
    Product create(CreateProductDto payload);
    Product update(Long id, UpdateProductDto payload);
    Product delete(Long id);
    
}
