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
// NamedAttributeNode bu hisse hemise  1 ci eager olarq join olur gelir
//type fetc ve load dan asli olmayarq
//load FetchTypa baxir isliyir
//fetc fetc kimi getirir yeni lazy
//@NamedEntityGraph(name = "account-user", attributeNodes = {
//        @NamedAttributeNode("user"),
//        @NamedAttributeNode("cards"),
//        @NamedAttributeNode(value = "cards", subgraph = "cards-subgraph")
//},
//        subgraphs = @NamedSubgraph(name = "cards-subgraph", attributeNodes = {
//                @NamedAttributeNode(value = "benefits")
//        }))

//@NamedQuery(name = "test", query = "select a from Account a join fetch a.user u join fetch a.cards c join fetch c.benefits b ")
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