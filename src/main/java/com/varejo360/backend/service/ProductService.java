package com.varejo360.backend.service;

import com.varejo360.backend.dto.ProductDto;
import com.varejo360.backend.dto.UserDto;
import com.varejo360.backend.model.Product;
import com.varejo360.backend.model.User;
import com.varejo360.backend.repository.ProductRepository;
import com.varejo360.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private  final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Product createProduct(final ProductDto productData) throws Exception{

        final User foundUser = userRepository.findById(productData.getUser_id()).orElseThrow(() -> new Exception("User not found"));

        final Product newProduct = new Product(foundUser, productData.getCode(), productData.getName());

        return productRepository.save(newProduct);
    }

    public List<Product> readProducts() {return productRepository.findAll();};

    public Product retrieveProduct(final long id) throws Exception {

        //esse tipo de tratamento de erro fecha o app, vamos modifica-lo
        return productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));

    }

    public Product updateProduct(final ProductDto productData, final long id) throws Exception {

        final Product foundProduct = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));

        foundProduct.setCode(productData.getCode());
        foundProduct.setName(productData.getName());


        return productRepository.save(foundProduct);

    }

    public void deleteProduct(final long id) throws Exception {

        final Product foundProduct = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));

        productRepository.delete(foundProduct);

    }
}
