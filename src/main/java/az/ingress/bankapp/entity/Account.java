package az.ingress.bankapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String accountNumber;
    private double balance;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<Card> cards;
}