package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.*;
import project.example.springapp.repository.*;

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

    public void orderfromproduct(int cusId){
        Customer customer=customerRepo.findById(cusId).get();
        for (int i = 0; i<customer.getCarts().size(); i++) {
            int proId = customer.getCarts().get(i).getProduct().getProductId();
            int quan= customer.getCarts().get(i).getQuantity();
            Products products= productRepo.findById(proId).get();
            Orders orders1=new Orders();
            orders1.setCustomer(customer);
            orders1.setProduct(products);
            orders1.setQuantity(quan);
            orderRepo.save(orders1);
            Long d_cartId=customer.getCarts().get(i).getDummyCartId();
            cartRepo.deleteById(d_cartId);
        }
    }


    public int d_cartcount(int cusId){
        Customer customer1=customerRepo.findById(cusId).get();
        int c=customer1.getCarts().size();
        return c;
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

