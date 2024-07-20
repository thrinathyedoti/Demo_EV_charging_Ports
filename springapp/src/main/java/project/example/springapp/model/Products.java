package project.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;
    private String product_name;
    private String chargingType;
    private double costperport;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Orders> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Cart> carts;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Exchange> exchangeOrders;


}
