package az.ingress.bankapp.mapper;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.entity.Card;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {


    @Mapping(target = "username",source = "user.username")
    @Mapping(target = "password",source = "user.password")
    @Mapping(target = "cardNumber", source="cards", qualifiedByName ="setCardNumber")
    @Mapping(target = "cardType", source="cards", qualifiedByName ="setCardType")
    @Mapping(target = "expirationDate", source="cards", qualifiedByName ="setCardDate")
    AccountDto entityToDto(Account account) ;


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