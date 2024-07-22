package project.example.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.springapp.model.Exchange;
import project.example.springapp.service.ExchangeService;

import java.util.List;


@RestController
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping("exchange/{cusId}/{orderId}/{productId}")
    public String exchange(@PathVariable int cusId,@PathVariable Long orderId,@PathVariable int productId){
        exchangeService.exchangeProduct(cusId, orderId, productId);
        return "Product Exchanged Successfully...";
    }
    @GetMapping("allexchanges")
    public List<Exchange>allExchanges(){
       return exchangeService.allexchanges();
    }
    @GetMapping("exchangesbycustomerid/{cusId}")
    public List<Exchange> exchangesByCustomerId(@PathVariable("cusId") int customerId){
        return exchangeService.exchangesByCustomerId(customerId);
    }



}
