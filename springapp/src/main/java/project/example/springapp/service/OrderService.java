package project.example.springapp.service;

import jakarta.persistence.criteria.Order;
import lombok.Setter;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Cart;
import project.example.springapp.model.Customer;
import project.example.springapp.model.Orders;
import project.example.springapp.repository.CartRepo;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.repository.DummyCartRepo;
import project.example.springapp.repository.OrderRepo;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class OrderService {
    @Autowired
    CartService cartService;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    Cart cart;
    @Autowired
    DummyCartRepo dummyCartRepo;
    @Autowired
    Orders orders;


    public void orderfromcart(int cusId){

        Customer customer=customerRepo.findById(cusId).get();
        ArrayList<Long> cartIds=new ArrayList<>();

        for(int i=0;i<customer.getCart().size();i++) {
            Cart cart = customer.getCart().get(i);
            Orders orders = new Orders();
            orders.setCart(cart);
            orders.setCustomer(customer);
            orderRepo.save(orders);
        }
        for(int i=0;i<customer.getDummyCarts().size();i++){
            cartIds.add(customer.getDummyCarts().get(i).getDummyCartId());
        }

        for (Long cartId:cartIds){
            dummyCartRepo.deleteById(cartId);
        }
        for(int i=0;i<cartIds.size();i++){
            cartIds.remove(i);
        }
    }

        public List<Orders> allOrders(){
            return orderRepo.findAll();
        }
    }

