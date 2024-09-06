package az.ingress.bankapp.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "accounts")

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "account-user",
                attributeNodes = {
                        @NamedAttributeNode("user"),
                        @NamedAttributeNode("cards"),
                        @NamedAttributeNode(value = "user", subgraph = "user-address-subgraph"),
                        @NamedAttributeNode(value = "cards", subgraph = "cards-benefits-subgraph")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "user-address-subgraph",
                                attributeNodes = {
                                        @NamedAttributeNode("address")
                                }
                        ),
                        @NamedSubgraph(
                                name = "cards-benefits-subgraph",
                                attributeNodes = {
                                        @NamedAttributeNode("benefits")
                                }
                        )
                }
        )
})
//@NamedQuery(name = "test", query = "select a from Account a join fetch a.user u join fetch u.address add join fetch a.cards c join fetch c.benefits b ")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private double balance;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "account")
    private Set<Card> cards;


}