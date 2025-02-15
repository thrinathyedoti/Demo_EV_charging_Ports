package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Cart;
import project.example.springapp.model.Customer;
import project.example.springapp.model.Products;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.repository.CartRepo;
import project.example.springapp.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;

    public void productTOCart(int cusId, int proId, int quantity){
        Customer customer = customerRepo.findById(cusId).get();
        Products products = productRepo.findById(proId).get();
        Cart cart = new Cart();
        cart.setProduct(products);
        cart.setCustomer(customer);
        cart.setQuantity(quantity);
        cartRepo.save(cart);
    }
    public List<Cart> allProductFromCart() {
       return cartRepo.findAll();
    }

    public void deleteProductFromCart(Long cartId){
                cartRepo.deleteById(cartId);
    }
    public void updateQuantityInCart(Long cartId, int quantity){
        Cart cart=cartRepo.findById(cartId).get();
        cart.setQuantity(quantity);
        cartRepo.save(cart);
    }

    public List<Cart> cartByCustomerId(int cusId){
        Customer customer=customerRepo.findById(cusId).get();
        List<Cart> cartList=new ArrayList<>();
        for(Cart cart:customer.getCart()){
            cartList.add(cart);
        }
        return cartList;
    }

}
