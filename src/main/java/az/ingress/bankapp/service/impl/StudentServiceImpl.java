package az.ingress.bankapp.service.impl;



import az.ingress.bankapp.dto.SearchCriteria;
import az.ingress.bankapp.entity.Student;
import az.ingress.bankapp.repository.StudentRepository;
import az.ingress.bankapp.service.StudentService;
import az.ingress.bankapp.spec.StudentSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Long saveStudent(Student student) {

        return studentRepository.save(student).getId();
    }


    @Override
    public List<Student> getAllStudents(Student student) {

        Specification<Student> studentSpecification = null;


        studentSpecification = (root, cq, cb) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (student.getName() != null) {
                predicateList.add(cb.equal(root.get("name"), student.getName()));
            }

            if (student.getSurname() != null) {
                predicateList.add(cb.equal(root.get("surname"), student.getSurname()));
            }

            cq.where(cb.and(predicateList.toArray(new Predicate[0])));
            return cq.getRestriction();

        };

        return studentRepository.findAll(studentSpecification);
    }

    //
    @Override
    public List<Student> getStudentsAll(String name, String surname, Long age) {
        Specification<Student> studentSpecification = null;

//        if (name != null) {
//            studentSpecification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
//
//        }

//        Specification<Student> studentSpecification2 = new Specification<Student>() {
//            @Override
//            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//
//               // return criteriaBuilder.equal(root.get("name"), name);
//                return criteriaBuilder.like(root.get("name"),"%"+ name + "%");
//            }
//        };

        studentSpecification = (root, cq, cb) -> {


            List<Predicate> predicateList = new ArrayList<>();

            if (name != null) {
                predicateList.add(cb.equal(root.get("name"),name));
            }


            if (surname!= null) {
                predicateList.add(cb.equal(root.get("surname"), surname));
            }

            if (age!= null) {
                predicateList.add(cb.greaterThan(root.get("age"), age));
            }

            predicateList.toArray(new Predicate[0]);
            cq.where(cb.and(predicateList.toArray(new Predicate[0])));
            return cq.getRestriction();

        };
       return studentRepository.findAll(studentSpecification);

    }
    @Override
    public List<Student> getStudents(String name, String surname, Long age, String gender) {
        return studentRepository.getStudnets(name,surname, age,gender);
    }
//

    @Override
    public List<Student> findAllStudents(List<SearchCriteria> searchCriteriaList) {
        StudentSpecification studentSpecification = new StudentSpecification();

        searchCriteriaList.forEach(searchCriteria -> studentSpecification.add(searchCriteria));

        return studentRepository.findAll(studentSpecification);

    }


    @Override
    public Page<Student> getStudentAll2(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }


    @CachePut(cacheNames = "student",key="#student.name.length()")
    @Override
    @Transactional
    public Student updateStudent(Student student, Long id) {

        if (studentRepository.findById(id).isPresent()){
           Student  st= studentRepository.findById(id).get();
           st.setAge(student.getAge());
           st.setName(student.getName());
           st.setSurname(student.getSurname());

            System.out.println("salam");

           return st;

        }
        System.out.println("sagol");
        return null;
    }

    @Override
    public Page<Student> getStudentAll(int pageSize, int pageNumber, String[] pageSort) {
      //  Pageable pageable1 = PageRequest.of(pageNumber, pageSize, Sort.by("id")); sort gondermeden
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(pageSort[0]).ascending().descending());
        return studentRepository.findAll(pageable);
    }
}
