package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.example.springapp.model.Products;
import project.example.springapp.repository.ProductRepo;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    public List<Products> allProducts(){
       return productRepo.findAll();
    }
    public  Products getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public void addProduct(Products products){
        productRepo.save(products);
    }
    public void updateProduct(Products products){
        productRepo.save(products);
    }
    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
