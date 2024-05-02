package az.ingress.bankapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private double balance;
    private String username;


    @ManyToOne
    private Add add;

}
