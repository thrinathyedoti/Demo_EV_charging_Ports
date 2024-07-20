package project.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import project.example.springapp.model.Exchange;

@Component
@Repository
public interface ExchangeRepo extends JpaRepository<Exchange, Long> {
}
