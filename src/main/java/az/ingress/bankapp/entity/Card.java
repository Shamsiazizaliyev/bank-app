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
@ToString
@Setter
@Getter

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Account account;
    private String cardNumber;
    private String cardType;
    private String expirationDate;

    @Version
    private Long versia;

    @OneToMany(mappedBy = "card",fetch = FetchType.EAGER)
    private List<CardBenefit> benefits;





}