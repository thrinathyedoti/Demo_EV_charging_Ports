package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Customer;
import project.example.springapp.model.DummyCart;
import project.example.springapp.model.Products;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.repository.DummyCartRepo;
import project.example.springapp.repository.ProductRepo;

import java.util.List;

@Component
@Service
public class DummyCartService {
    @Autowired
    DummyCartRepo dummyCartRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;

    public void productTOCart(int cusId, int proId, int quantity){
        Customer customer = customerRepo.findById(cusId).get();
        Products products = productRepo.findById(proId).get();
        DummyCart dummyCart = new DummyCart();
        dummyCart.setProduct(products);
        dummyCart.setCustomer(customer);
        dummyCart.setQuantity(quantity);
        dummyCartRepo.save(dummyCart);

    }
    public List<DummyCart> allProductFromdummyCart() {
       return dummyCartRepo.findAll();
    }
}
