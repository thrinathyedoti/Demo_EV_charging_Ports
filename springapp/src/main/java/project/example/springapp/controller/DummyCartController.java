package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import project.example.springapp.model.Customer;
import project.example.springapp.model.DummyCart;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.service.DummyCartService;

import java.util.List;

@RestController
public class DummyCartController {
    @Autowired
    DummyCartService dummyCartService;
    @Autowired
    CustomerRepo customerRepo;

    @PutMapping("{cusId}/{proId}/{quan}")
    public String addProductToCart(@PathVariable int cusId, @PathVariable int proId, @PathVariable int quan){
        dummyCartService.productTOCart(cusId, proId,quan);
        Customer cusName= customerRepo.findById(cusId).get();
        return "Ordered Successful, "+cusName.getCustomername();
    }

    @GetMapping("dummycartitems")
    public List<DummyCart> allProductFromCart(){
        return dummyCartService.allProductFromdummyCart();
    }
}
