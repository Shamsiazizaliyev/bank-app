package az.ingress.bankapp.config;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "authentication-service", url = "http://localhost:8080/bank-app")

public interface BankAppClient {

    @GetMapping("/test")
    public  String demo();



}
