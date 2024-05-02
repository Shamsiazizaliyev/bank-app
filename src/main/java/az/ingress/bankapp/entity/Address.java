package az.ingress.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String postalCode;

//    @Version
//    private Long version;

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id")



    private User user;





}