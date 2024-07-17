package project.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import project.example.springapp.model.DummyCart;

@Repository
public interface DummyCartRepo extends JpaRepository<DummyCart,Long> {
}
