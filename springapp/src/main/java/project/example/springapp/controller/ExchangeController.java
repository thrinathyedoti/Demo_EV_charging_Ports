package project.example.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.example.springapp.service.ExchangeService;


@RestController
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping("exchange/{cusId}/{orderId}/{productId}")
    public String exchange(@PathVariable int cusId,@PathVariable Long orderId,@PathVariable int productId){
        exchangeService.exchangeProduct(cusId, orderId, productId);
        return "Product Exchanged Successfully...";
    }


}
