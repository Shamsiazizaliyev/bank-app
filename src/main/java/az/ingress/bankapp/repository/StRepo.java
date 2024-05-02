package az.ingress.bankapp.repository;

import az.ingress.bankapp.entity.Ac;
import az.ingress.bankapp.entity.Add;
import az.ingress.bankapp.entity.Student;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface StRepo extends JpaRepository<Add,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<Add> findById(Long aLong);

}
