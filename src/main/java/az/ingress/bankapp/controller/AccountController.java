package az.ingress.bankapp.controller;


import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.entity.Ac;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.service.AccountService;
import az.ingress.bankapp.service.impl.Addimpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accouts")
@Tag(name = "Account Controllerr",description = "This controller managed  account" )
@Slf4j
public class AccountController {
    private final AccountService accountService;
    private final Addimpl service;

    public List<Account> getAccountDto() {

        return accountService.getAccountDto();
    }
    @Operation(summary = "GET METHOD",description = "get accoutn by id")
    @ApiResponse(responseCode = "2000", description = "Okey", content =
            { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Ac.class)) })
    @GetMapping("/{id}")
    public Ac getAccount(@PathVariable Long id){
        return service.getAcc(id);
    }
    @PutMapping("/{id}")
    public Ac updateAccount(@PathVariable Long id,
                                    @RequestParam Double amount) {
        return    service.updateAccount(id, amount);
    }
    @PutMapping("/wait/{id}")
    public Ac updateAccountWait(@PathVariable Long id, @RequestParam Double amount) {
        return    service.updateAccountWithWait(id, amount);
    }



    @PutMapping("/propagation/{id}")
    public Ac updateAccountWithPropagation(@PathVariable Long id, @RequestParam Double amount) {
        return  service.updateAccountWithPropagation(id, amount);
    }



    @GetMapping("/security")
    public String getPublic() {
        return "get public method";
    }

    @GetMapping("/security/1")
    public String getPublic1() {
     //   log.info("user is {}",principal);
        System.out.println("salam");
        return "get public method 1";
    }

    @GetMapping("/security/1/2")
    public String getPublic2() {
        return "get public method 1/2";
    }

    @PostMapping("/security")
    public String postPublic() {
        return "post public method";
    }

}
