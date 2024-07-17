package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Customer;
import project.example.springapp.model.Cart;
import project.example.springapp.model.DummyCart;
import project.example.springapp.model.Products;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.repository.CartRepo;
import project.example.springapp.repository.DummyCartRepo;
import project.example.springapp.repository.ProductRepo;

import java.util.List;

@Component
@Service
public class CartService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    Cart cart;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    DummyCartRepo dummyCartRepo;
//    one to one
//    public void addOrder(int cusId, int proId){
//
//        Customer customer = customerRepo.findById(cusId).get();
//        Products products  = productRepo.findById(proId).get();
//        cart.setCustomer(customer);
//        cart.setProduct(products);
//        cartRepo.save(cart);
//    }

    public void productTOCart(int cusId, int proId, int quantity){
       Customer customer = customerRepo.findById(cusId).get();
       Products products = productRepo.findById(proId).get();
       Cart cart =new Cart();
       cart.setProduct(products);
       cart.setCustomer(customer);
       cart.setQuantity(quantity);
       cartRepo.save(cart);
       DummyCart dummyCart = new DummyCart();
       dummyCart.setProduct(products);
       dummyCart.setCustomer(customer);
       dummyCart.setQuantity(quantity);
       dummyCartRepo.save(dummyCart);

    }
    public List<Cart> allProductFromCart(){
        return cartRepo.findAll();
    }

//    public List<Cart> productsByCustomerId(Long cusId){
//        return cartRepo.findByCustomerCustomer_id(cusId);
//    }

//    public String deleteByCustomerId(Long cusid){
//        cartRepo.deleteByCustomerCustomerId(cusid);
//        return "deleted successfully";
//    }

}
