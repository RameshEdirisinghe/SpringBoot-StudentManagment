package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentSrvice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {


    final StudentSrvice studentSrvice;

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
        studentSrvice.addStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentSrvice.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        studentSrvice.deleteStudent(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentSrvice.updateStudent(student);
    }

    @GetMapping("/search-by-id/{id}")
    public Student search(@PathVariable Integer id){
        return studentSrvice.searchById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Student> searchName(@PathVariable String name){
        return studentSrvice.searchByName(name);
    }
}
