package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import project.example.springapp.model.Cart;
import project.example.springapp.model.Customer;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.service.CartService;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    CustomerRepo customerRepo;

    @PutMapping("{cusId}/{proId}/{quan}")
    public String addProductToCart(@PathVariable int cusId, @PathVariable int proId, @PathVariable int quan){
        cartService.productTOCart(cusId, proId,quan);
        Customer cusName= customerRepo.findById(cusId).get();
        return "Added To Cart Successful, "+cusName.getCustomername();
    }

    @GetMapping("cartitems")
    public List<Cart> allProductFromCart(){
        return cartService.allProductFromCart();
    }
}
