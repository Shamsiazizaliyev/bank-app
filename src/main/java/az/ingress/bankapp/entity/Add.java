package az.ingress.bankapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Add {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressid;

    private String street;
    private String city;


}
