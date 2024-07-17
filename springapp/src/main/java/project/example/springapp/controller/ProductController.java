package project.example.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.springapp.model.Products;
import project.example.springapp.service.ProductService;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/allproducts")
    public List<Products> allCompanies(){
        return productService.allProducts();
    }

    @GetMapping("/getproductbyid/{id}")
    public Products getcompanyById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/addproduct")
    public String addCompany(@RequestBody Products products){
        productService.addProduct(products);
        return "Successfully added, "+products.getProduct_name();
    }
    @PutMapping("/updateproduct")
    public String updateCompany(@RequestBody Products products){
        productService.updateProduct(products);
        return "Updated, "+products.getProduct_name()+"Successfully";
    }
    @DeleteMapping("/deleteproduct/{id}")
    public String deleteCompany(@PathVariable int id){
        productService.deleteProduct(id);
        return "Successfully deleted...";
    }

}
