package az.ingress.bankapp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private double balance;
    @Schema(type = "string",example = "SHEMSI")
    private String username;
    
    @Version
    private Long version;



}
