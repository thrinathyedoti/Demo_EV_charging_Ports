package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return "Added To Cart Successfully, "+cusName.getCustomername();
    }
    @GetMapping("cartbycustomerid/{customerId}")
    public List<Cart> cartByCustomerId(@PathVariable int customerId){
        return cartService.cartByCustomerId(customerId);
    }
    @PutMapping("updatequantity/{cartId}/{quantity}")
    public void updateQuantity(@PathVariable Long cartId,@PathVariable int quantity){
        cartService.updateQuantityInCart(cartId,quantity);
    }
    @DeleteMapping("deleteproductfromCart/{cartId}")
    public void deleteProductInCart(@PathVariable Long cartId){
        cartService.deleteProductFromCart(cartId);
    }


    @GetMapping("cartitems")
    public List<Cart> allProductFromCart(){
        return cartService.allProductFromCart();
    }
}
