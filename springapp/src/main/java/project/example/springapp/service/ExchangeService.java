package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Customer;
import project.example.springapp.model.Exchange;
import project.example.springapp.model.Orders;
import project.example.springapp.model.Products;
import project.example.springapp.repository.CustomerRepo;
import project.example.springapp.repository.ExchangeRepo;
import project.example.springapp.repository.OrderRepo;
import project.example.springapp.repository.ProductRepo;

@Component
@Service
public class ExchangeService {

    @Autowired
    ExchangeRepo exchangeRepo;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderRepo orderRepo;

    public void exchangeProduct(int cusId, Long orderId, int newProductId) {
        String exchangeStatus1="Yes";
        Customer customer1=customerRepo.findById(cusId).get();
        Products products=productRepo.findById(newProductId).get();
        for (int i=0;i<customer1.getOrders().size();i++) {
            Orders orders1 = customer1.getOrders().get(i);
            if(orderId.equals(orders1.getOrderId())){
                Exchange exchange1=new Exchange();
                exchange1.setProduct(products);
                exchange1.setCustomer(customer1);
                exchange1.setQuantity(orders1.getQuantity());
                exchange1.setExchangedOrderId(orderId);
                exchangeRepo.save(exchange1);
                orders1.setExchangeStatus(exchangeStatus1);
                orderRepo.save(orders1);
            }
        }

    }


}
