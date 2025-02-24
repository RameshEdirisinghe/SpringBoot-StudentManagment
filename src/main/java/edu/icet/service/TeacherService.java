package edu.icet.service;

import edu.icet.dto.Teacher;

import java.util.List;

public interface TeacherService {

    void addTeacher(Teacher teacher);

    List<Teacher> getAll();

    void delete(Integer id);

    void update(Teacher teacher);

    Teacher searchById(Integer id);


}
