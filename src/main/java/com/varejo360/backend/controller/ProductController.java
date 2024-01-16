package com.varejo360.backend.controller;

import com.varejo360.backend.dto.ProductDto;
import com.varejo360.backend.dto.UserDto;
import com.varejo360.backend.model.Product;
import com.varejo360.backend.model.User;
import com.varejo360.backend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody final ProductDto productData) throws Exception {
        final Product  createdProduct = productService.createProduct(productData);

        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Product>> readProducts(){
        final List<Product> allProducts = productService.readProducts();

        return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> retrieveProduct(@PathVariable final String id) {

        final Product product = productService.retrieveProduct(Long.parseLong(id));

        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody final ProductDto productData, @PathVariable final String id) {
        //convertendo id (String) para Long
        final Product updatedProduct = productService.updateProduct(productData, Long.parseLong(id));

        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable final String id) {

        productService.deleteProduct(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }

}
