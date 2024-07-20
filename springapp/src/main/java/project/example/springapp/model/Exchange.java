package project.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long exchangeId;
    private Long exchangedOrderId;
    private int quantity;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Products product;


}
