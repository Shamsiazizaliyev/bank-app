package az.ingress.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String accountNumber;
    private double balance;
    private String username;
    private String password;
    private String cardNumber;
    private String cardType;
    private String expirationDate;
    private String description;
}
