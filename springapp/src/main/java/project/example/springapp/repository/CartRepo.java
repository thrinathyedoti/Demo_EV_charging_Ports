package project.example.springapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import project.example.springapp.model.Cart;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

    //List<Cart> findByCustomerCustomer_id(Long customerId);
    // void  deleteByCustomerCustomerId(int customerId);


//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Cart c WHERE c.customer.customerId = :customerId")
//    void deleteByCustomerId(@Param("customerId") int customerId);

}
