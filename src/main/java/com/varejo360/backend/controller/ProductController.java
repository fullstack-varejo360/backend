package com.varejo360.backend.controller;

import com.varejo360.backend.dto.ProductDto;
import com.varejo360.backend.dto.UserDto;
import com.varejo360.backend.model.Product;
import com.varejo360.backend.model.User;
import com.varejo360.backend.service.ProductService;
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
    public ResponseEntity<Product> createProduct(@RequestBody final ProductDto productData) throws Exception {
        final Product  createdProduct = productService.createProduct(productData);

        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Product>> readProducts(){
        final List<Product> allProducts = productService.readProducts();

        return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> retrieveProduct(@PathVariable final String id) throws Exception {

        final Product product = productService.retrieveProduct(Long.parseLong(id));

        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @PutMapping("/{id}")                                                    //aqui sugere (throws Exception) por conta do service
    public ResponseEntity<Product> updateProduct(@RequestBody final ProductDto productData, @PathVariable final String id) throws Exception {
        //convertendo id (String) para Long
        final Product updatedProduct = productService.updateProduct(productData, Long.parseLong(id));

        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable final String id) throws Exception {

        productService.deleteProduct(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }

}
