package project.example.springapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import project.example.springapp.model.Customer;

import java.util.List;

@Component
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findByState(String state);
    Customer findByCustomername(String name);


}
