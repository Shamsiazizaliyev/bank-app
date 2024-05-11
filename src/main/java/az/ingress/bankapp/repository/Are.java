package az.ingress.bankapp.repository;

import az.ingress.bankapp.entity.Ac;
import az.ingress.bankapp.entity.Account;
import az.ingress.bankapp.entity.Add;
import az.ingress.bankapp.entity.Address;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;


public interface Are extends JpaRepository<Ac,Long> {


    @Lock(LockModeType.OPTIMISTIC)
    @Override
    Optional<Ac> findById(Long aLong);

}

