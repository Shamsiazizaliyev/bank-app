package az.ingress.bankapp.repository;


import az.ingress.bankapp.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.address a")
    Set<User> findByCustom();


//    @EntityGraph(attributePaths = {"authorities"})
//    Optional<User> findByUsername(String username);



}
