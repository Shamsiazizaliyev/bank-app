package az.ingress.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


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

    @OneToOne
    @ToString.Exclude
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

}