package project.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartId;

    private int quantity;


    //@OneToOne
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;



    //@OneToOne
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;

    @JsonIgnore
    @OneToMany(mappedBy = "cart")
    List<Orders> orders;
}
