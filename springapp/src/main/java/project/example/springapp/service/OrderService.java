package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.*;
import project.example.springapp.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    Orders orders;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    Customer customer;

    public void addOrder(int cusId){
        Customer customer=customerRepo.findById(cusId).get();
        String exchange="NO";
        for (int i = 0; i<customer.getCart().size(); i++) {
            int proId = customer.getCart().get(i).getProduct().getProductId();
            int quan= customer.getCart().get(i).getQuantity();
            Products products= productRepo.findById(proId).get();
            Orders orders1=new Orders();
            orders1.setCustomer(customer);
            orders1.setProduct(products);
            orders1.setQuantity(quan);
            orders1.setExchangeStatus(exchange);
            orderRepo.save(orders1);
            Long d_cartId=customer.getCart().get(i).getCartId();
            cartRepo.deleteById(d_cartId);
        }

    }

    public List<Orders> ordersByCustomerId(int cusId){
        Customer customer1=customerRepo.findById(cusId).get();
        List<Orders> ordersList=new ArrayList<>();
        for (Orders orders1:customer1.getOrders()){
            ordersList.add(orders1);
        }
        return ordersList;

    }



//    public void orderfromcart(int cusId){
//
//        Customer customer=customerRepo.findById(cusId).get();
//        ArrayList<Long> cartIds=new ArrayList<>();
//
//        for(int i=0;i<customer.getCart().size();i++) {
//            Cart cart = customer.getCart().get(i);
//            Orders orders = new Orders();
//            orders.setCart(cart);
//            orders.setCustomer(customer);
//            orderRepo.save(orders);
//        }
//        for(int i=0;i<customer.getCarts().size();i++){
//            cartIds.add(customer.getCarts().get(i).getDummyCartId());
//        }
//
//        for (Long cartId:cartIds){
//            cartRepo.deleteById(cartId);
//        }
//        for(int i=0;i<cartIds.size();i++){
//            cartIds.remove(i);
//        }
//    }

        public List<Orders> allOrders(){
            return orderRepo.findAll();
        }
    }

