package id.impecto.modules.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.impecto.modules.products.dto.CreateProductDto;
import id.impecto.modules.products.dto.UpdateProductDto;
import id.impecto.modules.products.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/products")
@Tag(name = "Product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductDto payload) {
        Product product = productService.create(payload);        
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findOne(@PathVariable Long id) {
        Product product = productService.findOne((Long)id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody UpdateProductDto payload) {
        Product product = productService.update((Long)id, payload);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @DeleteMapping(path =  "/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product product = productService.delete((Long) id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    
}
