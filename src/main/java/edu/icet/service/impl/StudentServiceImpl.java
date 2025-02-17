package edu.icet.service.impl;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentDao;
import edu.icet.service.StudentSrvice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentSrvice {

    final ModelMapper modelMapper;


    final StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.save(modelMapper.map(student, StudentEntity.class));
    }

    @Override
    public List<Student> getAll() {

        List<Student> studentList = new ArrayList<>();
        List<StudentEntity> all = studentDao.findAll();

        all.forEach(studentEntity -> {
            studentList.add(modelMapper.map(studentEntity,Student.class));
        });
        return studentList;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.save(modelMapper.map(student, StudentEntity.class));
    }

    @Override
    public Student searchById(Integer id) {
        return modelMapper.map(studentDao.findById(id),Student.class);
    }

    @Override
    public List<Student> searchByName(String name) {

        List<StudentEntity> searchByNameList = studentDao.findByName(name);
        List<Student> studentList = new ArrayList<>();

        for (StudentEntity studentEntity : searchByNameList) {
            studentList.add(modelMapper.map(studentEntity,Student.class));
        }
        return studentList;
    }


}
