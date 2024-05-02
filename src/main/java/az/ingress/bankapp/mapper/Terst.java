package az.ingress.bankapp.mapper;

import az.ingress.bankapp.entity.Card;
import org.mapstruct.Named;

import java.util.Set;

public interface Terst {


    @Named("setCardNumber")
    default String setCardNumber(Set<Card> cards){
        return cards.stream().findFirst().get().getCardNumber();
    }
    @Named("setCardType")
    default String setCardType(Set<Card> cards){
        return cards.stream().findFirst().get().getCardType();
    }
    @Named("setCardDate")
    default String setCardDate(Set<Card> cards){
        return cards.stream().findFirst().get().getExpirationDate();
    }
}
