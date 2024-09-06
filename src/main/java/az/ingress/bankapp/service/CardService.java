package az.ingress.bankapp.service;

import az.ingress.bankapp.dto.AccountDto;
import az.ingress.bankapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final AccountRepository   accountRepository;

    public List<AccountDto> getAccount() {
      //  return accountRepository.findAllCustom();
        return null;
    }
}
