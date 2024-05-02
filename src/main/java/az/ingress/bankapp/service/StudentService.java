package az.ingress.bankapp.service;



import az.ingress.bankapp.dto.SearchCriteria;
import az.ingress.bankapp.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Long saveStudent(Student student);

  List<Student> getAllStudents(Student student);
//
   List<Student> getStudentsAll(String name, String surname,Long age);
   List<Student> getStudents(String name, String surname,Long age,String gender);
//
   List<Student> findAllStudents(List<SearchCriteria> searchCriteriaList);
//
   Page<Student> getStudentAll(int pageSize, int pageNumber, String[] pageSort);
   Page<Student> getStudentAll2(Pageable pageable);

   Student updateStudent(Student student, Long id);


}
