package project.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.example.springapp.model.Cart;
import project.example.springapp.model.DummyCart;
import project.example.springapp.repository.DummyCartRepo;

import java.util.List;

@Component
@Service
public class DummyCartService {
    @Autowired
    DummyCartRepo dummyCartRepo;

    public List<DummyCart> allProductFromdummyCart() {
       return dummyCartRepo.findAll();
    }
}
