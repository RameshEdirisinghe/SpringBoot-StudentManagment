package edu.icet.controller;

import edu.icet.dto.Teacher;
import edu.icet.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @GetMapping("/all-teacher")
    public List<Teacher> getAll(){
        return service.getAll();
    }

    @PostMapping("/add-teacher")
    public void addTeacher(@RequestBody Teacher teacher){
        service.addTeacher(teacher);
    }

    @DeleteMapping("/delete-teacher/{id}")
    public void deleteTeacher(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("/update-teacher")
    public void updateTeacher(@RequestBody Teacher teacher){
        service.update(teacher);
    }

    @GetMapping("/search-by-id-teacher/{id}")
    public Teacher searchByid(@PathVariable Integer id){
        return service.searchById(id);
    }

}
