package project.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.example.springapp.model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
}
