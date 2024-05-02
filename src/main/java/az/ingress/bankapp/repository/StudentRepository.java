package az.ingress.bankapp.repository;


import az.ingress.bankapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    Optional<Student> findByName(String name);
    Optional<Student> findByNameAndAge(String name,Long age);
    Optional<List<Student>> findByNameIsLike(String name);

    Optional<Student> findBySurname(String surname);

   Optional<List<Student>> findByNameAndSurnameAndAgeAndGender(String name, String surname, int age, String gender);
//

    @Query("select s from Student s where (:name is null or s.name=:name) " +
            "and (:surname is null or s.surname =: surname) " +
            "and (:age is null or s.age=:age) " +
            "and (:gender is null or s.gender=:gender) ")
    List<Student> getStudnets(@Param("name") String name,
                              @Param("surname") String surname,
                              @Param("age") Long age,
                              @Param("gender") String gender);

}
