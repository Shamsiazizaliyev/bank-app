package az.ingress.bankapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;







    @ManyToOne
    private Account account;

    private String cardNumber;
    private String cardType;
    private String expirationDate;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<CardBenefit> benefits;
}