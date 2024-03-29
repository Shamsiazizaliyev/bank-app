package az.ingress.bankapp.repository;

import az.ingress.bankapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card,Long> {
}
