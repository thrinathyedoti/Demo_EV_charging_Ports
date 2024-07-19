package project.example.springapp.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String customername;
    private String mobilenumber;
    private String email;
    private String state;
    private String city;
    private String area;



    @OneToMany(mappedBy = "customer")
    List<Cart> carts;

    @OneToMany(mappedBy = "customer")
    List<Orders> orders;

}
