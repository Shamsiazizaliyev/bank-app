package az.ingress.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDto {


    private Long id;

    private String accountNumber;
    private double balance;
    private String username;

}
