package az.ingress.bankapp.controller;


import az.ingress.bankapp.dto.SearchCriteria;
import az.ingress.bankapp.entity.Student;
import az.ingress.bankapp.repository.StudentRepository;
import az.ingress.bankapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor




public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;
    private  final CacheManager cacheManager;
   // private  final RedisTemplate<String,Object> redisTemplate;

    @Cacheable(cacheNames = "student",key="#name.length()")
    @GetMapping("/student/{name}")

    public Student getStudent(@PathVariable String name) {


        System.out.println("salam");
        return studentRepository.findByName(name).orElseThrow(RuntimeException::new);


//        System.out.println("salam");
//       Cache cache=cacheManager.getCache("student");
//       Student studentcache= Objects.requireNonNull(cache).get(name,Student.class);
//
//       if(cache==null){
//
//           System.out.println("iff");
//           Student student = studentRepository.findByName(name).orElseThrow(RuntimeException::new);
//           cache.put(student.getName(),student);
//       }
//            return (Student) cache.get(name).get();
    }


    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable Long id) {
        return studentService.updateStudent(student,id);
    }

    @CacheEvict(cacheNames = "student",key = "#name.length()")
    @DeleteMapping("/student/{id}/{name}")
    public Long deleteStudent(@PathVariable Long id,@PathVariable String name){
        Student student =studentRepository.findById(id).orElseThrow(RuntimeException::new);

        studentRepository.delete(student);
        return student.getId();
    }


    @PostMapping("/student")
    public ResponseEntity<List<Student>> findAllStudents(@RequestBody List<SearchCriteria> searchCriteriaList) {
        return ResponseEntity.ok(studentService.findAllStudents(searchCriteriaList));
    }

    @GetMapping("/student/alll")
   public ResponseEntity<Page<Student>> getStudentAll(Pageable pageable){

        return ResponseEntity.ok(studentService.getStudentAll2(pageable));

    }


    @GetMapping("/student/all")
    public ResponseEntity<Page<Student>> getStudentAll(@RequestParam(value = "pageSize") int pageSize,
                                                       @RequestParam(value = "pageNumber") int pageNumber,
                                                       @RequestParam(value = "pageSort") String[] pageSort) {
        return ResponseEntity.ok(studentService.getStudentAll(pageSize, pageNumber, pageSort));
   }
}
