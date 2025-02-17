package edu.icet.service;

import edu.icet.dto.Student;

import java.util.List;

public interface StudentSrvice {
    void addStudent(Student student);

    List<Student> getAll();

    void deleteStudent(Integer id);

    void updateStudent(Student student);

    Student searchById(Integer id);
    List<Student> searchByName(String name);
}
