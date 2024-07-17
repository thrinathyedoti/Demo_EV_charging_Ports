package project.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.example.springapp.model.Cart;
import project.example.springapp.model.DummyCart;
import project.example.springapp.service.DummyCartService;

import java.util.List;

@RestController
public class DummyCartController {
    @Autowired
    DummyCartService dummyCartService;

    @GetMapping("dummycartitems")
    public List<DummyCart> allProductFromCart(){
        return dummyCartService.allProductFromdummyCart();
    }
}
