package project.example.springapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DummyCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long dummyCartId;

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



}
