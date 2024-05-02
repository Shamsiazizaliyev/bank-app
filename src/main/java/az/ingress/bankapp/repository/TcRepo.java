package az.ingress.bankapp.repository;

import az.ingress.bankapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TcRepo extends JpaRepository<Teacher,Long> {


    @Query(value = "select * from banks.teacher t\n" +
            "inner join banks.add a on a.addressid = t.add_addressid;", nativeQuery = true)
    List<Teacher> findByCustomNative();
}
